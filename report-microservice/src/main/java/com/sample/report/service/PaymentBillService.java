package com.sample.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.report.domain.PaymentBill;
import com.sample.report.repository.PaymentBillRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This service provides methods to persist payment bill information.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Slf4j
@Service
public class PaymentBillService {

	@Autowired
	private PaymentBillRepository billRepository;
	
	public void createPaymentBill(PaymentBill bill) {
		billRepository.save(bill);
	}
}
