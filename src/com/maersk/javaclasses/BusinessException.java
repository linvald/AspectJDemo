package com.maersk.javaclasses;

/**
 * @author Jesper Linvald (jesper@linvald.net)
 *
 */
public class BusinessException extends Exception{

	public BusinessException(String msg){
		super("BusinessException:" + msg);
	}
	public BusinessException(){
		super();
	}
}
