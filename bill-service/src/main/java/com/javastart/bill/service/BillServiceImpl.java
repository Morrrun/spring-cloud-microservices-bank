package com.javastart.bill.service;

import com.javastart.bill.entity.Bill;
import com.javastart.bill.exception.BillNotFoundException;
import com.javastart.bill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException("Unable to find bill with id: " + billId));
    }

    public Long createBill(Long accountId, BigDecimal amount,
                           Boolean isDefault, Boolean overdraftEnabled) {

        Bill bill = Bill.builder()
                .billId(accountId)
                .amount(amount)
                .isDefault(isDefault)
                .creationDate(OffsetDateTime.now())
                .overdraftEnabled(overdraftEnabled)
                .build();

        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount,
                           Boolean isDefault, Boolean overdraftEnabled) {

        Bill bill = Bill.builder()
                .billId(accountId)
                .amount(amount)
                .isDefault(isDefault)
                .creationDate(OffsetDateTime.now())
                .overdraftEnabled(overdraftEnabled)
                .build();

        bill.setBillId(billId);

        return billRepository.save(bill);
    }

    public Bill deleteBill(Long billId) {
        Bill dletedBill = getBillById(billId);

        billRepository.deleteById(billId);

        return dletedBill;
    }

}
