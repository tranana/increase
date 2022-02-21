package com.tran.increase.basics.authority.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tran.increase.basics.authority.bean.TranBasicsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * @author luxiangqian
 * 2022/2/20
 */
@Mapper
public interface TranBasicsUserDAO extends BaseMapper<TranBasicsUser> {

    /**
     * 用户是否存在
     * @param userId
     * @return
     */
    Integer selectCountById(@Param("userId") String userId);



}
