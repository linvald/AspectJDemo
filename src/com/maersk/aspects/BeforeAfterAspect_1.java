package com.maersk.aspects;

import com.maersk.javaclasses.*;


public aspect BeforeAfterAspect_1 {	
 
    /**
     * This is a pointcut which works on RegularJavaClass -
     * It intercepts all calls on any get method (i.e. getMyPrivateField)
     * - after it returns it increments our count field (declared in this aspect) and prints it out
     * It also prints the signature of the method beeing called 
     */
	pointcut count(RegularJavaClass h): call(* com.maersk.javaclasses.*.get*(..)) && target(h);   
		before(RegularJavaClass h) : count(h) {
			System.out.println("  [Before] Entering "+ thisJoinPoint.getSignature());
			System.out.println("Get info:" + h.fieldInfo());
		}
    	after(RegularJavaClass h) : count(h) {
			h.count++;
			System.out.println("  [After] Counted: " + h.count + " calls to " + thisJoinPoint.getSignature());
			//how to get new value from getMyPrivateField without hitting pointcut recursively? 
		}

	//hits new on RegularJavaClass - prints out before contruction
	pointcut initNew() : call(RegularJavaClass.new(..));	
		before():initNew()  {
			System.out.println("Constructing object of type " + thisJoinPoint.getSignature());
		}
		
	/** Introducing a field in existing class */
	private int RegularJavaClass.count = 0;
  	
  	
	interface Dummy{public String fieldInfo();}
  	
	/** We can make existing classes extend or implement other classes/interfaces */
	declare parents : RegularJavaClass implements Dummy; 
  	
	/** Introducing a method */
	public String RegularJavaClass.fieldInfo(){
		//NB:this points to RegularJavaClass
		return this.getClass().getInterfaces()[0].toString();
	}	

}
