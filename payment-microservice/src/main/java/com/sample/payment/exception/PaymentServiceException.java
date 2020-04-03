package com.sample.payment.exception;

import org.springframework.stereotype.Component;

/**
 * This class creates related exceptions for payment services based on the exception type. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Component
public class PaymentServiceException extends Exception {

	public static RuntimeException throwException(String messageTemplate, String... args) {
		return new RuntimeException(messageTemplate);
	}

	public static class InvalidInputDataException extends RuntimeException {
		public InvalidInputDataException(String message) {
			super(message);
		}
	}

	public static RuntimeException throwException(ExceptionType exceptionType, String message) {
		if (ExceptionType.INVALID_INPUT_DATA.equals(exceptionType)) {
			return new InvalidInputDataException(message);
		}
		return new RuntimeException(message);
	}
}
