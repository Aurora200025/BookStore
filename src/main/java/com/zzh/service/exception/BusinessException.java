package com.zzh.service.exception;

/**
 * @Author Aurora
 * @Date 2021/1/10 13:00
 * @Version 1.0
 * 与业务逻辑相关的异常
 */
public class BusinessException extends RuntimeException {

    private String code;
    private String msg;

    public BusinessException(String code, String msg) {
        super(code + " : " + msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
