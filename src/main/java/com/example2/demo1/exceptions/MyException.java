package com.example2.demo1.exceptions;

public class MyException extends RuntimeException {

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyException() {
    }

    public MyException(String msg) {this.msg = msg;
    }
}
