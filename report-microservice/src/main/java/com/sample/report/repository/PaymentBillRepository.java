package com.sample.report.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.report.domain.PaymentBill;

/**
 * This repository handles PaymentBill entity's queries. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Repository
public interface PaymentBillRepository extends CrudRepository<PaymentBill, Integer>{

}
