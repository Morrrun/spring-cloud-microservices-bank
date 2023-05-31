package com.javastart.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@AllArgsConstructor
@Getter
public class BillRequestDto {
    private Long billId;
    private Long accountId;
    private BigDecimal amount;
    private Boolean isDefault;
    private OffsetDateTime creationDate;
    private Boolean overdraftEnabled;
}
