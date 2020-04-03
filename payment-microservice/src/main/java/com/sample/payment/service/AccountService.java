package com.sample.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.payment.domain.Account;
import com.sample.payment.dto.AccountDto;
import com.sample.payment.exception.AccountServiceException;
import com.sample.payment.exception.ExceptionType;
import com.sample.payment.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This service provides methods to add, update, delete and find an account.
 *
 * @author Mahnaz
 * @Mar 13, 2020
 */

@Slf4j
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountModelMapper accountModelMapper;

	public AccountDto createAccount(AccountDto accountRequest) {

		Account createdAccount = accountRepository.save(accountModelMapper.convertAccountDtoToEntity(accountRequest));
		log.debug("New account created sucessfully");

		// convert created account entity to DTO
		return accountModelMapper.convertAccountEntityToDto(createdAccount);
	}

	public Boolean deleteAccount(Integer accountId) {
		log.debug("Deleting account by id {}", accountId);

		// check account existence by the id
		boolean isExists = accountRepository.existsById(accountId);
		if (isExists) {
			accountRepository.deleteById(accountId);
			log.info("Account by id {} deleted", accountId);
			return true;
		} else {
			throw AccountServiceException.throwException(ExceptionType.ACCOUNT_NOT_FOUND_EXCEPTION, "Account not found");
		}
	}

	public AccountDto findAccountById(Integer accountId) {
		log.debug("Finding account by id {}", accountId);
		Optional<Account> account = accountRepository.findById(accountId);
		if (account.isPresent()) {
			return accountModelMapper.convertAccountEntityToDto(account.get());
		} else {
			log.info("Account by id {} not found", accountId);
			return null;
		}
	}

	public AccountDto updateBalance(AccountDto accountDto) {
		log.debug("Updating account balance by id {}", accountDto.getId());

		// check account existence by the id
		Optional<Account> foundAccount = accountRepository.findById(accountDto.getId());
		if (foundAccount.isPresent()) {
			foundAccount.get().setBalance(accountDto.getBalance());
			accountRepository.save(foundAccount.get());
			log.info("Account balance updated for id {}", foundAccount.get().getId());

		} else {
			throw AccountServiceException.throwException(ExceptionType.ACCOUNT_NOT_FOUND_EXCEPTION,
					"Account not found");
		}

		return accountModelMapper.convertAccountEntityToDto(foundAccount.get());
	}
}
