package com.tran.increase.basics.base.result;

import lombok.Data;

/**
 * @author luxiangqian
 * 2022/2/20
 */
@Data
public abstract class AuthorityDTO {

    /**
     * 用户ID 分隔
     */
    String userIds;

    /**
     * 名称
     */
    String name;

    /**
     * 查看权限
     */
    String operate;

    /**
     * 查看权限
     */
    String view;

}
