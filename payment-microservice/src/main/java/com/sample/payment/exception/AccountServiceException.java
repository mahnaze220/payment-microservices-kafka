package com.sample.payment.exception;

import org.springframework.stereotype.Component;

/**
 * This class creates related exceptions for account services based on the exception type. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Component
public class AccountServiceException extends Exception{

	public static RuntimeException throwException(String messageTemplate, String... args) {
		return new RuntimeException(messageTemplate);
	}

	public static class AccountNotFoundException extends RuntimeException {
		public AccountNotFoundException(String message) {
			super(message);
		}
	}
	
	public static RuntimeException throwException(ExceptionType exceptionType, String message) {
		if (ExceptionType.ACCOUNT_NOT_FOUND_EXCEPTION.equals(exceptionType)) {
			return new AccountNotFoundException(message);
		}
		return new RuntimeException(message);
	}

}

