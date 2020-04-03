package com.sample.payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.payment.dto.AccountDto;
import com.sample.payment.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This controller provides REST services to create, find, delete and update an account.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@RestController
@Validated
@Api(value = "API to create, update, delete and find an account", produces = "application/json")
public class AccountController {

	@Autowired
	private AccountService accountService;

	/**
	 * Creates a new account 
	 * 
	 * @param accountDto - {@link AccountDto} request of creating a new account
	 * @return AccountDto - information of the created account
	 */
	@PostMapping(value = "/createAccount")
	@ApiOperation(value = "Create new account", response = AccountDto.class)
	@ApiParam(name = "accountDto", value = "New account to be created", required = true)
	public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody final AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	/**
	 * Finds the account by the id
	 * 
	 * @param accountId - id of the account
	 * @return AccountDto - information of the found account
	 */
	@GetMapping(value = "/findAccountById")
	@ApiOperation(value = "Find account by ID", response = AccountDto.class)
	@ApiParam(name = "accountId", value = "The ID of the account to be searched", required = true)
	public ResponseEntity<AccountDto> findAccountById(@RequestParam final Integer accountId) {
		return new ResponseEntity<>(accountService.findAccountById(accountId), HttpStatus.OK);
	}

	/**
	 * Deletes the account by the id
	 * 
	 * @param accountId - id of the account
	 * @return Long - response status code
	 */
	@DeleteMapping(value = "/deleteAccount")
	@ApiOperation(value = "Delete account by ID")
	@ApiParam(name = "accountId", value = "The ID of the account to be deleted", required = true)
	public ResponseEntity<Long> deleteAccount(@RequestParam final Integer accountId) {
		accountService.deleteAccount(accountId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Updates existing account's balance
	 * 
	 * @param accountDto - {@link AccountDto} request of updating account's balance
	 * @return AccountDto information of updated account
	 */
	@PutMapping(value = "/updateAccountBalanace")
	@ApiOperation(value = "Update account balance", response = AccountDto.class)
	@ApiParam(name = "accountDto", value = "Account to be updated", required = true)
	public ResponseEntity<AccountDto> updateBalance(@Valid @RequestBody final AccountDto accountDto) {
		return new ResponseEntity<>(accountService.updateBalance(accountDto), HttpStatus.OK);
	}
}
