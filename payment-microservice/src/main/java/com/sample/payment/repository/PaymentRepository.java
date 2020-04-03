package com.sample.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.payment.domain.Payment;

/**
 * This repository handles Payment entity's queries. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
