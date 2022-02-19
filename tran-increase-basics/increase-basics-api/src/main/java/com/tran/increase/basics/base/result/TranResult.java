package com.tran.increase.basics.base.result;

import lombok.Data;

/**
 * @author luxiangqian
 * 2022/2/19
 */
@Data
public abstract class TranResult<T> {

    /**
     * 状态码
     */
    Integer code;

    /**
     * 提示信息
     */
    String message;

    /**
     * 返回结果
     */
    T data;




}
