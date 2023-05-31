package com.javastart.accountservice.service;

import com.javastart.accountservice.entity.Account;
import com.javastart.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.javastart.accountservice.exeption.AccountNotFoundException;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {
    private final AccountRepository accountRepository;

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Unable to find account with id: " + accountId));
    }

    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        Account account = Account.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .createDate(OffsetDateTime.now())
                .bills(bills)
                .build();

        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
        Account account = new Account().builder()
                .accountId(accountId)
                .name(name)
                .email(email)
                .phone(phone)
                .bills(bills)
                .build();
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long accountId) {
        Account deleteAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);

        return deleteAccount;
    }
}
