package com.sample.report.event;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.sample.report.domain.PaymentBill;

/**
 * This service provides methods for adding and updating user information.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

public class PaymentDeserializer extends JsonDeserializer<PaymentBill> {

	public PaymentDeserializer() {
		super(PaymentBill.class);
	}
}
