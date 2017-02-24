package org.hari.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hari.javabrains.model.Circle;

//@Aspect
public class LoggingAspect {
	
	/*
	 * @Before("execution(public String org.hari.javabrains.model.Circle.getName())")   --> for one particular method or to restrict
	   @Before("execution(public String getName())")   --> wild card for all getName() which return String
	 * wild card for all getters irrespective of return type, we can also remove return type & can pass * as parameter too, for o or more arguments get*(..) should be given
     */
	
	@Before("allCircleMethods()")  
	public void LoggingAdvice(JoinPoint joinPoint) {
	//	System.out.println("Advice run. Get Method called");
		
		
		/* jointPoint.getTarget() returns the object of the method who triggered--> in this case 
		 * Getters of circle, so circle object is returned
		 * Circle circle = (Circle) joinPoint.getTarget();
		 */
	}
	
	/* 
	 * below pointcut will call all the methods that take single argument of String -->args(Strng)
	 * argument that is passed to args is also being passed to this method
	 * this will help have handle on arguments, for preprocessing purposes
	 * before Circle.setName is set, spring.xml will first set the values that were mentioned in <property> after beans are set 
	 * PointCuts are called. 
	 */
	
	/* 
	 * @AfterReturning can be used if we want target to run successfully & then to the advice
	 */
	
	
	/*
	 * adding two property, so we can pass & also handle return object
	 */
	//@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgumentMethods(String name, Object returnString){
		System.out.println("A method that takes String arguments has been called " + name + " the output of setMethodandReturn is " + returnString.toString());
	}
	
	//@AfterReturning("args(name)")
	public void stringArgumentMethods(String name){
		System.out.println("A method that takes String arguments has been called " + name );
	}
	
	//@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name, Exception ex){
		System.out.println("And exception has been thrown" + ex);
	}
	
	
	/*
	 *  we have defined Pointcut in the below method, so we are now passing method name 
	
	@Before("allGetters() && allCircleMethods()")    
	public void secondAdvice() {
		System.out.println("Second Advice executed");
	}
	 */
	/*
	 * we can use this expression here & use dummy method as many types as we want
	 */
	
	//@Pointcut("execution(* get*())")  
	public void allGetters() {} 
	
	/*
	 * you can also use for package & subpackages, within(org.hari.javabrains.model.*) or within(org.hari.javabrains.model.. 
	 */
	
	//@Pointcut("within(org.hari.javabrains.model.Circle)")
	public void allCircleMethods() {}

	/*
	 * 	@Around("@annotation(org.hari.javabrains.aspect.Loggable)") for custom annotations
	 */
	//@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnValue = null;
		
		try {
			System.out.println("Before target");
			returnValue = proceedingJoinPoint.proceed();  //we can also skip this target method execution if needed --> 1 of adv of @Around 
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue; //we can also modify the returnValue, unlike @After where we cannot modify the arguments --> another adv. for @Around
	}
	
	
	/*
	 * @Pointcut(args()) --> arguments that method we have to have, Pointcut expression for a method 
	 * that take circle object as parameter, 
	 * so args will take all Interface objects or user defined objects & we can apply pointcut expressions 
	 */
	
	// target & Proxy are other two pointcut expressions, check javadoc
	
	
	/*
	 * best practices : Chain point cuts with logical operators. Basically mix & match without recreating many
	 *  
	 */
	
	
	public void loggingAdvice(){
		System.out.println("Logging from advice");
	}
}
