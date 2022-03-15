package com.bol.kalah.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAOP {
    @Pointcut("execution(* com.bol.kalah.service.*.*(..))")
    private void serviceLayerExecution() {
    }

    @Pointcut("execution(* com.bol.kalah.api.*.*(..))")
    private void restLayerExecution() {
    }


    @Around("serviceLayerExecution() || restLayerExecution()")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        Logging.writeLog(LogStatus.START, joinPoint);

        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();

        Logging.writeLog(LogStatus.END, joinPoint, retVal, stopWatch.getTotalTimeMillis());

        return retVal;
    }


    @AfterThrowing(pointcut = "serviceLayerExecution() || restLayerExecution()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        Logging.writeLog(LogStatus.Exception, joinPoint, ex);
    }
}
