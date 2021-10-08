package com.digitalinovationone.gft.exception;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1249908965504018266L;
	
	transient private Object[] args;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Object[] args) {
		super(message);
		this.args = args;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message, Throwable cause, Object[] args) {
		super(message, cause);
		this.args = args;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
