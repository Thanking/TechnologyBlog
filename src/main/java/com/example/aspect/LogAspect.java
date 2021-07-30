package com.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author : LSD
 * @version : 1.0
 * @ClassName : LogAscpect
 * @Description : TODO
 * @date : 2021/7/23 13:30
 * 请求url
 * 访问者ip
 * 调用的方法
 * 参数
 * 返回的内容
 **/
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //定义切面入口
    @Pointcut("execution(* com.example.controller.*.*(..))")
    public void log(){}
    //获取所有请求信息
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //构建记录日志类
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //对请求进行null断言
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //获取请求的内容
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        //将请求的数据传入logger
        logger.info("Request : {}" , requestLog);
    }

    @After("log()")
    public void doAfter(){
        //logger.info("-------doAfter---------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result){
        logger.info("Result : {}" , result);
    }
    //记录日志内容类
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
