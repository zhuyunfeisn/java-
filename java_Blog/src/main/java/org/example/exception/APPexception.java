package org.example.exception;

/**
 * 自定义异常类：业务代码抛自定义异常或者其他异常
 * 自定义异常返回给定的错误码，其他异常返回其他错误码
 */

public class APPexception extends RuntimeException{
    //给前端返回json字符串中，保存错误码
    private String code;
    //message父类自带，返回josn字符串中，保存错误信息给用户用
    public APPexception(String code,String message) {
        super(message);
        this.code=code;
    }

    public APPexception(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
