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
 * Created by jinyan on 8/7/17 2:35 PM.
 */
@Aspect
@Component
public class MonitorService {
    private static final Logger logger = LoggerFactory.getLogger(MonitorService.class);

    @Around("execution(* swa.manage.biz.impl.RoomBizImpl.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) {
        logger.info("{} callMethod begin:{}", joinPoint.toLongString(), joinPoint.getArgs());
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        logger.info("{} callMethod end:{}", joinPoint.toLongString(), result);

        return result;
    }



}
