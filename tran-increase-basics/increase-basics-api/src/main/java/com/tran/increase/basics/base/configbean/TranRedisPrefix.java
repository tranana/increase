package com.tran.increase.basics.base.configbean;

/**
 * @author luxiangqian
 * 2022/2/20
 */
public interface TranRedisPrefix {

    /**
     * 过期时间
     * @return 过期时间
     */
    int expirationTime();

    /**
     * 设置前缀
     * @return 前缀
     */
    String prefix();




}
