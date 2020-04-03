package com.sample.payment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This entity holds persisted payment information. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private PaymentState state;
	
	@NotNull
	private Double amount;
	
	@NotNull
	private Integer sourceAccountId;
	
	@NotNull
	private Integer destinationAccountId;

	public Payment(@NotNull PaymentState state, @NotNull Double amount, @NotNull Integer sourceAccountId,
			@NotNull Integer destinationAccountId) {
		super();
		this.state = state;
		this.amount = amount;
		this.sourceAccountId = sourceAccountId;
		this.destinationAccountId = destinationAccountId;
	}
	
}
