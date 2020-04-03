package com.sample.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.payment.domain.Account;

/**
 * This repository handles Account entity's queries. 
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
