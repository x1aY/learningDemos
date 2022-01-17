package org.hhu.xy.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnoAOP {

    @Before("execution(* org.hhu.xy.service.User.*(..))")
    public void beforeDIY(){
        System.out.println("diy before");
    }

    @After("execution(* org.hhu.xy.service.User.*(..))")
    public void afterDIY(){
        System.out.println("diy after");
    }

}
