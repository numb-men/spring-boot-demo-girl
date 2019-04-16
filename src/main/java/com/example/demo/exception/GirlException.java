package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class GirlException extends RuntimeException{ //继承自运行时错误

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
