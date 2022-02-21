package com.tran.increase.basics.base.configbean;

import lombok.Data;

/**
 * @author luxiangqian
 * 2022/2/20
 */
@Data
public class TranRedisPrefix {

    /**
     * 过期时间
     * @return 过期时间
     */
    public int expirationTime;

    /**
     * 设置前缀
     * @return 前缀
     */
    public String prefix;


    public TranRedisPrefix(String prefix,int expirationTime) {
        this.expirationTime = expirationTime;
        this.prefix = prefix;
    }

    public TranRedisPrefix(String prefix) {
        this.prefix = prefix;
    }



}
