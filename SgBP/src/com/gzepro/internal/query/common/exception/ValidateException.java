package com.gzepro.internal.query.common.exception;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class ValidateException extends Exception{
	private String errorCode;
    public ValidateException(String errorCode) {
        super(errorCode); 
    	this.errorCode =errorCode;
    }

    public String toString() {
        if (super.getCause() == null) {
            return super.getMessage();
        } else {
            return super.getCause().getMessage();
        }
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
