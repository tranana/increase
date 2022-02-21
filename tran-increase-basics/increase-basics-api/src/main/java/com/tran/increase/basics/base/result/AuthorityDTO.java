package com.tran.increase.basics.base.result;

import lombok.Data;

/**
 * 公共权限抽象类
 * @author luxiangqian
 * 2022/2/20
 */
@Data
public  class AuthorityDTO extends BaseAuthority{

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
