package com.imooc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component //标记为组件
@Aspect //标记为切面类
public class MethodCheck {
    // 是JoinPoint的升级版，除了原功能外，还可以控制目标方法是否执行
    // 环绕通知，参数为Pointcut切点表达式
    @Around("execution(* com.imooc..*Service.*(..))")
    public Object cheeck(ProceedingJoinPoint pjp) throws Throwable {

        try {
            Long startTime = new Date().getTime() ;
            // 执行目标方法
            Object ret = pjp.proceed() ;
            Long endTime = new Date().getTime();
            Long duration = endTime - startTime ;
            if ( duration >= 1000 ){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");
                    String className = pjp.getTarget().getClass().getName() ;
                    String methodName = pjp.getSignature().getName();
                    String now = sdf.format(new Date()) ;
                System.out.println("====="+now+":"+className+"--"+methodName);
            }
            return ret ;
        } catch (Throwable e) {
            throw e ;
        }
    }
}
