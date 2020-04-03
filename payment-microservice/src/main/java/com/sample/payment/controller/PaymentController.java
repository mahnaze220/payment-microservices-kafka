package com.sample.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.payment.dto.AccountDto;
import com.sample.payment.dto.PaymentDto;
import com.sample.payment.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This controller provides REST services to do payment transaction between account.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@RestController
@Validated
@Api(value = "API to do payment transaction", produces = "application/json")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/**
	 * Do payment between accounts
	 * 
	 * @param paymentDto - {@link PaymentDto} request of doing payment
	 * @return PaymentDto - information of the done payment
	 */
	@PostMapping(value = "/doPayment")
	@ApiOperation(value = "Do payment", response = AccountDto.class)
	@ApiParam(name = "paymentDto", value = "Payment data to be done", required = true)
	public ResponseEntity<PaymentDto> doPayment(@Valid @RequestBody final PaymentDto paymentDto) {
		return new ResponseEntity<>(paymentService.doPayment(paymentDto), HttpStatus.CREATED);
	}

}
