package com.javastart.bill.service;

import com.javastart.bill.entity.Bill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface BillService {
    Bill getBillById(Long billId);

    Long createBill(Long accountId, BigDecimal amount,
                    Boolean isDefault, Boolean overdraftEnabled);

    Bill updateBill(Long billId, Long accountId, BigDecimal amount,
                    Boolean isDefault, Boolean overdraftEnabled);

    Bill deleteBill(Long billId);
}
