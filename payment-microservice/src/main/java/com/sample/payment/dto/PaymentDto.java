package com.sample.payment.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sample.payment.domain.PaymentState;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This DTO holds payment information. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Data
@RequiredArgsConstructor
public class PaymentDto {
	
    private Integer id;
	
	@NotNull(message = "Amount must not be null")
	@JsonProperty("amount")
	@ApiModelProperty(notes = "amount")
    private Double amount;
    
	@NotNull(message = "Source account ID must not be null")
	@JsonProperty("sourceAccountId")
	@ApiModelProperty(notes = "sourceAccountId", required = true)
    private Integer sourceAccountId;
    
	@NotNull(message = "Destination account ID must not be null")
	@JsonProperty("destinationAccountId")
	@ApiModelProperty(notes = "destinationAccountId", required = true)
    private Integer destinationAccountId;
	
    private PaymentState state;
    
}
