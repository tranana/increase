package com.tran.increase.basics.global;

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
     * @param userID 用户id
     * @return
     */
    List<Map<String,Object>> getAuthorityInfo(String userID);


    /**
     * 给用户某一种添加权限
     * @param userID 用户id
     * @param name 定义的权限名称
     * @return
     */
    AuthorityResult addUserAuthority(String userID,String name);

    /**
     * 删除用户权限
     * @param userID 用户id
     * @param name 定义的权限名称
     * @return
     */
    AuthorityResult delUserAuthority(String userID,String name);
}
