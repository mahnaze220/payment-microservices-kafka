package com.sample.report.domain;

/**
 * This enum holds different statues of a payment transaction. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

public enum PaymentState {

	CREATED,
	EXECUTED,
	REJECTED,
	CANCELED;
}
