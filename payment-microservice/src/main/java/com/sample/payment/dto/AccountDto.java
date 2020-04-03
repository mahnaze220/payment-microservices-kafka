package com.sample.payment.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This DTO holds account information. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Data
@RequiredArgsConstructor
public class AccountDto {

	private Integer id; 
	
	private Double balance;

	public AccountDto(Integer id, Double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public void updateBalance(Double amount) {
		balance = Double.sum(balance, amount);
	}

}
