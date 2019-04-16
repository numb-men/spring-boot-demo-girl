package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log() { }

    //Before代表之前
    //指定拦截的方法 ..代表任何参数
    //com.example.demo.controller.GirlController.*(..)拦截所有方法
    @Before("execution(public * com.example.demo.controller.GirlController.girlList(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Not allow!");
        logger.info("Not allow!"); //使用spring自带的日志管理

        //记录请求的内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_mathod={}", joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

        /**
         * url=http://127.0.0.1:8081/girl/girls
         * method=GET
         * ip=127.0.0.1
         * class_mathod=com.example.demo.controller.GirlController.girlList
         * args={}
         */
    }

    // 直接使用Pointcut公用的方法
    @After("log()")
    public void doAfter() {
        System.out.println("Do after");
        logger.info("Do after");
    }

    //返回时执行，打印返回数据
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        if (object != null){
            logger.info("response={}", object.toString());
        }
        //response=[Girl{id=2, cupSize='F', age=28, money=null},  ...]
    }
}
