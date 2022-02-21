package com.tran.increase.basics.base.result;

import lombok.Data;

/**
 * 认证权限
 * @author luxiangqian
 * 2022/2/21
 */
@Data
public abstract class BaseAuthority  {

    /**
     * 当前用户Id
     */
    private String user;


}
