package com.tran.increase.basics.base.result;

/**
 * 权限返回结果
 *
 * @author luxiangqian
 * 2022/2/19
 */
public  class AuthorityResult extends TranResult {


    public final static AuthorityResult  AUTHORITY_SUCCEED = ok();
    public final static  AuthorityResult  AUTHORITY_ERROR = error();
    public final static  AuthorityResult  AUTHORITY_ERROR_USER_NO = error(100002,"用户不存在");


    /**
     * 构造器
     * @param code
     * @param message
     */
    private AuthorityResult(Integer code,String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    private AuthorityResult(ResultEnumerate enumerate) {
        this.setCode(enumerate.getCode());
        this.setMessage(enumerate.getMessage());
    }



    public static AuthorityResult ok() {
        return new AuthorityResult(ResultEnumerate.SUCCEED);
    }

    public static AuthorityResult ok(Integer code,String message) {
        return new AuthorityResult(code,message);
    }

    public static AuthorityResult error() {
        return new AuthorityResult(ResultEnumerate.ERROR);
    }

    public static AuthorityResult error(Integer code,String message) {
        return new AuthorityResult(code,message);
    }
}
