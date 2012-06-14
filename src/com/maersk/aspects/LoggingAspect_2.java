package com.maersk.aspects;
import com.maersk.*;
import java.util.ArrayList;

public aspect LoggingAspect_2 {
  		
  	
  		private java.io.PrintStream logger = System.out;
  		
  		//we target any set method in specified package with signature public void set* with number of args
		pointcut anySet():
			call(public void com.maersk.javaclasses.*.set*(..));
	   
		before(): anySet() {
			logger.println("Before calling setter " + thisJoinPoint.getSignature());
		}
	   
		after() returning: anySet() {
			Object[] args = thisJoinPoint.getArgs();
			logger.println("After SETTER " + thisJoinPoint.getSignature() + " with args:" );
			for (int i = 0; i < args.length; i++) {
				Object arg = args[i];
				logger.println("Arg " + i + " type = " + arg.getClass() + " value = "+ arg);
			}
		}
		
		//lets catch any of the methods when they throw exceptions
		after() throwing (Exception e): anySet() {
			logger.println("An exception was thrown:" + e);
		}

	/** we log any calls on public getters in com.maersk.javaclasses*/
	pointcut anyGet():
		call(public * com.maersk.javaclasses.*.get*());
		
		after()returning:anyGet(){
			logger.println("After GETTER " + thisJoinPoint.getSignature());
		}
}
