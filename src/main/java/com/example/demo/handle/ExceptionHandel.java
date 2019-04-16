package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.GirlException;
import com.example.demo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandel {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(value = Exception.class) //自定义处理异常
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtils.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("【系统异常】", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
