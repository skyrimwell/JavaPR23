package app.Application;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private Logger log = Logger.getLogger(Aspect.class.getName());

    @Around("allServiceMethods()")
    public Object logExecutionTime (ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        //log.log(Level.INFO, joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        log.info(joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }

    @Pointcut("within(app.Application.Services.*)")
    public void allServiceMethods() {}
}
