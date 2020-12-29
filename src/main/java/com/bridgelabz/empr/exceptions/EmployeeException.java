package com.bridgelabz.empr.exceptions;

public class EmployeeException extends Exception {
	public enum ExceptionType{
		EMPLOYEE_NOT_FOUND
	}
	
	public ExceptionType type;
	
	public EmployeeException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public EmployeeException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
