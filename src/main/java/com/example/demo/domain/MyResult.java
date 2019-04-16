package com.example.demo.domain;

import com.example.demo.enums.ResultEnum;

public class MyResult<T> {

    private ResultEnum resultEnum;
    private String msg;
    private Integer code;
    private T data;

    public MyResult(ResultEnum resultEnum, T data) {
        this.resultEnum = resultEnum;
        this.msg = resultEnum.getMsg();
        this.code = resultEnum.getCode();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
