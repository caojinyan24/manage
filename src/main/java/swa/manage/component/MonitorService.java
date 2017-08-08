package swa.manage.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * controller层日志打印
 * Created by jinyan on 8/7/17 2:35 PM.
 */
@Aspect
@Component
public class MonitorService {
    private static final Logger logger = LoggerFactory.getLogger(MonitorService.class);

    @Around("execution(* swa.manage.controller.*.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) {
        logger.info("{} callMethod begin:{}", joinPoint.toShortString(), joinPoint.getArgs());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("{} callMethod end:{}", joinPoint.toShortString(), result);

        return result;
    }



}
