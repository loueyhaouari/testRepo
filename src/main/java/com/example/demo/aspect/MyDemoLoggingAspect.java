package com.example.demo.aspect;

import com.example.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Around("execution(* com.example.demo.dao.AccountDAO.findAccounts(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceeding) throws Throwable{
String method= theProceeding.getSignature().toShortString();
System.out.println("\n========> Executing @Around on method: "+method);
long begin=System.currentTimeMillis();
Object result=theProceeding.proceed();
long end=System.currentTimeMillis();
long duration=end-begin;
System.out.println("\n========> Duration: "+duration/1000.0 +"seconds");
        return result;

    }
    @After("execution(* com.example.demo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @After (finally) on method: "+method);
    }
    @AfterReturning(pointcut ="execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",returning ="result")
    public void afterReturingFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: "+method);
        System.out.println("---------");
        System.out.println("\n=====> result is: " +result);
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
    for(Account tempAccount:result){
        String theUpperName=tempAccount.getName().toUpperCase();
        tempAccount.setName(theUpperName);
    }
    }

    @Before("com.example.demo.aspect.LuvAopExpressions.forDaoPackage().forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("Executing @before advice on addAccount()");
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig);
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
           System.out.println(tempArg);
           if (tempArg instanceof Account){
               Account theAccount=(Account) tempArg;
               System.out.println("account name : "+theAccount.getName() );
               System.out.println("account level : "+theAccount.getLevel());
           }
        }
    }


}
