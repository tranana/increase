package com.tran.increase.basics.global;

import com.tran.increase.basics.base.result.AuthorityDTO;
import com.tran.increase.basics.base.result.AuthorityResult;

import java.util.List;
import java.util.Map;

/**
 * 权限统一接口
 * @author luxiangqian
 * 2022/2/19
 */
public interface Authority {

    /**
     * 获取用户下所有权限信息
     * @return
     */
    List<Map<String,Object>> getAuthorityInfo(AuthorityDTO authorityDTO);



    /**
     * 更新用户权限

     * @return
     */
    AuthorityResult updateUserAuthority(AuthorityDTO authorityDTO);
}
