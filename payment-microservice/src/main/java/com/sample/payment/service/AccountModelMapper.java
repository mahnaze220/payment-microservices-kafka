package com.sample.payment.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sample.payment.domain.Account;
import com.sample.payment.domain.Payment;
import com.sample.payment.dto.AccountDto;
import com.sample.payment.dto.PaymentDto;

/**
 * This class convert entities to DTOs and vice versa by using ModelMapper library.  
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Component
public class AccountModelMapper {

	public Account convertAccountDtoToEntity(AccountDto accountDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(accountDto, Account.class);
	}

	public AccountDto convertAccountEntityToDto(Account accountEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return  modelMapper.map(accountEntity, AccountDto.class);
	}
	
	public Payment convertPaymentDtoToEntity(PaymentDto paymentDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(paymentDto, Payment.class);
	}

	public PaymentDto convertPaymentEntityToDto(Payment paymentEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return  modelMapper.map(paymentEntity, PaymentDto.class);
	}

}
