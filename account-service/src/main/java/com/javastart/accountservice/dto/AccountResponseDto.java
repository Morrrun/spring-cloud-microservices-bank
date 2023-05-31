package com.javastart.accountservice.dto;

import com.javastart.accountservice.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDto {
    private Long accountId;
    private String name;
    private String email;
    private String phone;
    private OffsetDateTime createDate;
    private List<Long> bills;

    public AccountResponseDto(Account account) {
        this.accountId = account.getAccountId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.createDate = account.getCreateDate();
        this.bills = account.getBills();
    }
}
