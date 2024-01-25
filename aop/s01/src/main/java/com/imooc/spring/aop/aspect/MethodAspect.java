package com.imooc.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodAspect {
    //切面方法，用于扩展额外的功能
    // JoinPoint，连接点，通过连接点可以获取目标类/方法的信息
    public void printExcutionTime(JoinPoint joinPoint){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS");
        String now = sdf.format(new Date());
        // 获取目标类的名称
        String className = joinPoint.getTarget().getClass().getName();
        String methodName  = joinPoint.getSignature().getName() ;
        System.out.println("+++++++++++++++++++++++++");
        System.out.println(now+":"+className+"."+methodName);
    }
}
