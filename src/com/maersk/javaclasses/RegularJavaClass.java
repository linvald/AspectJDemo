package com.maersk.javaclasses;



public class RegularJavaClass {

	private String myPrivateField="privateFieldValue";
	 
	
	public RegularJavaClass(){

	}
	
	public String getMyPrivateField() {
		return myPrivateField;
	}


	public void setMyPrivateField(String string) throws BusinessException{
		if(string.length()>9)throw new BusinessException("BusinessException - string to long");
		myPrivateField = string;
	}
	
	
	public void doSomeExceptionalStuff()throws BusinessException{ 
		throw new BusinessException("");
		 
	}

}
