package com.maersk.javaclasses;

public class TestAspectsMain { 

	public static void main(String[] args) {
		RegularJavaClass c = new RegularJavaClass();
	
		try {
			c.setMyPrivateField("one");
			System.out.println(c.getMyPrivateField());
			c.setMyPrivateField("two");
			System.out.println(c.getMyPrivateField());
			c.setMyPrivateField("three");
			System.out.println(c.getMyPrivateField());
			c.setMyPrivateField("alltoverylongstring");
		} catch (BusinessException e) {
			System.out.println("Caught businessEx in main:" + e);
		}
	

		
		new RegularJavaClass();
	}

}
