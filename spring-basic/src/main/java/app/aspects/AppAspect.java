package app.aspects;

import app.annotations.BasicAuthorization;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class AppAspect {

    @Before("@annotation(app.annotations.SampleAnnotation)||@target(app.annotations.SampleAnnotation)")
    public void logFuncNameAndTime(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " called at " + new Date());
    }

    @Before("execution(* *.*(..)) && @annotation(basicAuthorization) ")
    public void accessToBalance(JoinPoint joinPoint, BasicAuthorization basicAuthorization) {
        System.out.println("Access to " + joinPoint.getSignature().toShortString() + " is authorized with policy: "
                + basicAuthorization.policyName());
    }

    @Around("execution(* *.*(..)) && @annotation(app.annotations.BasicMeasurement)")
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        System.out.println("execution of " + joinPoint.getSignature().toShortString() +
                " took: " + (System.nanoTime() - start) + " nano seconds");
        return result;
    }
}
