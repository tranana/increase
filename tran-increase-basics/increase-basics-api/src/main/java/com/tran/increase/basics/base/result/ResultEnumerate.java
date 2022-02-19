package com.tran.increase.basics.base.result;

/**
 * @author luxiangqian
 * 2022/2/19
 */
public enum ResultEnumerate {

    SUCCEED(200,"请求成功"),
    ERROR(100000,"请求失败");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }


    ResultEnumerate(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
