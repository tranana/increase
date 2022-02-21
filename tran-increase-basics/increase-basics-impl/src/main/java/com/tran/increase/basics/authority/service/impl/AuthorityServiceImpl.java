package com.tran.increase.basics.authority.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.tran.increase.basics.authority.bean.TranBasicsAuthority;
import com.tran.increase.basics.authority.dao.TranBasicsAuthorityDAO;
import com.tran.increase.basics.authority.dao.TranBasicsUserDAO;
import com.tran.increase.basics.authority.service.AuthorityService;
import com.tran.increase.basics.base.configbean.TranRedisPrefix;
import com.tran.increase.basics.base.result.AuthorityDTO;
import com.tran.increase.basics.base.result.AuthorityResult;
import com.tran.increase.basics.base.util.BaseStringUtil;
import com.tran.increase.basics.base.util.TranRedisService;
import com.tran.increase.basics.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author luxiangqian
 * 2022/2/18
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {


    @Autowired
    private TranBasicsAuthorityDAO tranBasicsAuthorityDAO;


    @Autowired
    private TranBasicsUserDAO tranBasicsUserDAO;


    @Autowired
    private TranRedisService tranRedisService;

    @Override
    public List<Map<String, Object>> getAuthorityInfo(AuthorityDTO authorityDTO) {
        TranRedisPrefix redisPrefix = new TranRedisPrefix(Constant.REDIS_USER_AUTHORITY,86400);
        String userID = authorityDTO.getUserIds();
        // redis 中是否存在
        if (tranRedisService.exists(redisPrefix,userID)){
            // 刷新时间
            tranRedisService.refresh(redisPrefix, userID);
            return tranRedisService.get(redisPrefix, userID, List.class);
        }else {
            List<Map<String, Object>> authorityByUserId = tranBasicsAuthorityDAO.getAuthorityByUserId(userID);
            tranRedisService.set(redisPrefix, userID, authorityByUserId);
            return authorityByUserId;
        }
    }

    @Override
    @Transactional
    public AuthorityResult updateUserAuthority(AuthorityDTO authorityDTO) {
        // 如果用户不为空
        if (BaseStringUtil.isNotBlank(authorityDTO.getUserIds())){
            String[] users = authorityDTO.getUserIds().split(",");
            for (String user : users) {
                // 是否存在
                if (tranBasicsUserDAO.selectCountById(user) != 0 ){
                    tranBasicsAuthorityDAO.delAuthorityByIdAndName(user,authorityDTO.getName());
                    TranBasicsAuthority tranBasicsAuthority = new TranBasicsAuthority();
                    tranBasicsAuthority.setAuthorityId(IdUtil.simpleUUID());
                    tranBasicsAuthority.setUserId(user);
                    tranBasicsAuthority.setOperate(authorityDTO.getOperate());
                    tranBasicsAuthority.setView(authorityDTO.getView());
                    tranBasicsAuthority.setAuthorityName(authorityDTO.getName());
                    tranBasicsAuthority.setCreateTime(DateUtil.formatDate(DateUtil.date()));
                    tranBasicsAuthorityDAO.insert(tranBasicsAuthority);
                }
                return AuthorityResult.AUTHORITY_ERROR_USER_NO;
            }
            return AuthorityResult.AUTHORITY_SUCCEED;
        }
        return AuthorityResult.error();
    }



}
