package com.sample.report.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.sample.report.domain.PaymentBill;
import com.sample.report.service.PaymentBillService;

import lombok.extern.slf4j.Slf4j;

/**
 * This Kafka listener listen to topics by name 'payment'
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Component
@Slf4j
public class PaymentKafkaListener {

	@Autowired
	private PaymentBillService billService;
	
	@KafkaListener(topics = "payment")
	public void payment(PaymentBill bill, Acknowledgment acknowledgment) {
		log.info("Received payment " + bill.getId());
		billService.createPaymentBill(bill);
		acknowledgment.acknowledge();
	}
}
