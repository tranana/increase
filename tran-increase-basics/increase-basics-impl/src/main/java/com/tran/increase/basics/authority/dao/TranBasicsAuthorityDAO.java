package com.tran.increase.basics.authority.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tran.increase.basics.authority.bean.TranBasicsAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 权限
 * @author luxiangqian
 * 2022/2/20
 */
@Mapper
public interface TranBasicsAuthorityDAO extends BaseMapper<TranBasicsAuthority> {

    /**
     * 根据用户 ID 获取用户的操作权限
     *
     * @return
     */
    List<Map<String, Object>> getAuthorityByUserId(@Param("userId")String userId);

    /**
     * 是否存在
     * @param userId
     * @return
     */
    Integer delAuthorityByIdAndName(@Param("userId") String userId,@Param("name") String name);

}
