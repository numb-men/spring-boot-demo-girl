package com.example.demo.domain;

/**
 * Http请求返回的最外层对象
 */
public class Result<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */

    private String msg;

    /** 具体内容 */
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
