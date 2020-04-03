package com.sample.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sample.payment.domain.Payment;
import com.sample.payment.domain.PaymentState;
import com.sample.payment.dto.AccountDto;
import com.sample.payment.dto.PaymentDto;
import com.sample.payment.exception.ExceptionType;
import com.sample.payment.exception.PaymentServiceException;
import com.sample.payment.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This service provides methods for doing payment transactions.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Slf4j
@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountModelMapper modelMapper;

	@Autowired
	private KafkaTemplate<String, Payment> kafkaTemplate;

	public PaymentDto doPayment(PaymentDto paymentDto) {

		Payment payment = modelMapper.convertPaymentDtoToEntity(paymentDto);
		if (paymentDto.getDestinationAccountId() == null) {
			throw PaymentServiceException.throwException(ExceptionType.INVALID_INPUT_DATA
					, "Destination account cannot be null");
		}

		if (paymentDto.getSourceAccountId() == null) {
			throw PaymentServiceException.throwException(ExceptionType.INVALID_INPUT_DATA
					, "Source account cannot be null");
		}

		AccountDto srcAccount = accountService.findAccountById(paymentDto.getDestinationAccountId());
		if (srcAccount == null) {
			paymentDto.setState(PaymentState.REJECTED);
			return paymentDto;
		}

		AccountDto destAccount = accountService.findAccountById(paymentDto.getSourceAccountId());
		if (destAccount == null) {
			paymentDto.setState(PaymentState.REJECTED);
			return paymentDto;
		}

		if(srcAccount.getBalance().equals(0d) || srcAccount.getBalance() < paymentDto.getAmount()) {
			paymentDto.setState(PaymentState.REJECTED);
			return paymentDto;
		}

		payment.setState(PaymentState.EXECUTED);
		srcAccount.updateBalance(-paymentDto.getAmount());
		accountService.updateBalance(srcAccount);
		log.info("Balance of source account by id {} was updated", srcAccount.getId());

		destAccount.updateBalance(paymentDto.getAmount());
		accountService.updateBalance(destAccount);
		log.info("Balance of destination account by id {} was updated", destAccount.getId());

		paymentRepository.save(payment);

		firePaymentCreatedEvent(payment);
		return modelMapper.convertPaymentEntityToDto(payment);
	}

	private void firePaymentCreatedEvent(Payment payment) {
		kafkaTemplate.send("payment", payment.getId() + "created", payment);
		log.info("Payment tranaction sent to the kafka server");
	}

}
