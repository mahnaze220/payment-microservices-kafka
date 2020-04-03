package com.sample.report.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This entity holds persisted payment bill information. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "BILL")
public class PaymentBill {

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
	
	@NotNull
	private Date transactionDate = new Date();

}
