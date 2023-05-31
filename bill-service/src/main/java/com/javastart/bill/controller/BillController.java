package com.javastart.bill.controller;

import com.javastart.bill.dto.BillRequestDto;
import com.javastart.bill.dto.BillResponseDto;
import com.javastart.bill.service.BillService;
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
public class BillController {
    private final BillService billService;

    @GetMapping("/{billId}")
    public BillResponseDto getBill(@PathVariable
                                   Long billId) {
        return new BillResponseDto(billService.getBillById(billId));
    }

    @PostMapping("/")
    public Long createBill(@RequestBody
                           BillRequestDto billRequest) {
        return billService.createBill(
                billRequest.getAccountId(),
                billRequest.getAmount(),
                billRequest.getIsDefault(),
                billRequest.getOverdraftEnabled());
    }

    @PutMapping("/{billId}")
    public BillResponseDto updateBill(@PathVariable
                                      Long billId,
                                      @RequestBody
                                      BillRequestDto billRequest) {
        return new BillResponseDto(billService.updateBill(
                billId,
                billRequest.getAccountId(),
                billRequest.getAmount(),
                billRequest.getIsDefault(),
                billRequest.getOverdraftEnabled()));
    }

    @DeleteMapping("/{billId}")
    public BillResponseDto deleteBill(@PathVariable
                                      Long billId) {
        return new BillResponseDto(billService.deleteBill(billId));
    }

}
