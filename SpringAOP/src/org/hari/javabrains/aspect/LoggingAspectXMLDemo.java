package org.hari.javabrains.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspectXMLDemo {
	
	@After("justForTriangle()")
	public void triangleAdvice(){
		System.out.println("Triangle advice for GET");
	}
	
	@Pointcut("execution(* get*())")
	public void justForTriangle(){}
	
}
