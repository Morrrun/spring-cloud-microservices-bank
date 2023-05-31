package com.javastart.accountservice.service;

import com.javastart.accountservice.entity.Account;

import java.util.List;

public interface AccountService {
     Account getAccountById(Long accountId);

     Long createAccount(String name,
                        String email,
                        String phone,
                        List<Long> bills);

     Account updateAccount(Long accountId,
                           String name,
                           String email,
                           String phone,
                           List<Long> bills);

    public Account deleteAccount(Long accountId);
}
