package org.bedoing.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.bedoing.blog.aspect.AroundLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RootResourceInformation;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(public * org.springframework.data.rest.webmvc.RepositoryEntityController.get*(..)) && args(resourceInformation,..)")
    public void before(JoinPoint jp, RootResourceInformation resourceInformation) {
        logger.info("before " + jp);
    }

    @Around("@annotation(aroundLog)")
    public Object aroundLogMethod(ProceedingJoinPoint jp, AroundLog aroundLog) throws Throwable {
        return aroundLog(jp, aroundLog);
    }

    @Around("within(@AroundLog *) && @target(aroundLog)")
    public Object aroundLogClass(ProceedingJoinPoint jp, AroundLog aroundLog) throws Throwable {
        return aroundLog(jp, aroundLog);
    }

    public Object aroundLog(ProceedingJoinPoint jp, AroundLog aroundLog) throws Throwable {
        try {
            log(logger, aroundLog.level(), "start " + jp );
            return jp.proceed();
        } finally {
            log(logger, aroundLog.level(), "finished " + jp );
        }
    }

    private static void log(Logger logger, String level, String txt) {
        if (logger != null && level != null) {
            switch (level) {
                case "trace":
                    logger.trace(txt);
                    break;
                case "debug":
                    logger.debug(txt);
                    break;
                case "info":
                    logger.info(txt);
                    break;
                case "warn":
                    logger.warn(txt);
                    break;
                case "error":
                    logger.error(txt);
                    break;
            }
        }
    }
}
