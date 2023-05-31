package com.javastart.accountservice.controller;

import com.javastart.accountservice.dto.AccountRequestDto;
import com.javastart.accountservice.dto.AccountResponseDto;
import com.javastart.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public AccountResponseDto getAccount(@PathVariable
                                         Long accountId) {
        return new AccountResponseDto(accountService.getAccountById(accountId));
    }

    @PostMapping("/")
    public Long createAccount(@RequestBody
                              AccountRequestDto accountRequest) {
        return accountService.createAccount(
                accountRequest.getName(),
                accountRequest.getEmail(),
                accountRequest.getPhone(),
                accountRequest.getBills());
    }

    @PutMapping("/{accountId}")
    public AccountResponseDto updateAccount(@PathVariable
                                            Long accountId,
                                            @RequestBody
                                            AccountRequestDto accountRequest) {
        return new AccountResponseDto(
                accountService.updateAccount(
                        accountId,
                        accountRequest.getName(),
                        accountRequest.getEmail(),
                        accountRequest.getPhone(),
                        accountRequest.getBills()));
    }

    @DeleteMapping("/{accountId}")
    public AccountResponseDto deleteAccount(@PathVariable
                                            Long accountId) {
        return new AccountResponseDto(accountService.deleteAccount(accountId));
    }
}
