package app.aspects;

import app.annotations.BasicAuthorization;
import org.aspectj.lang.JoinPoint;
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
}
