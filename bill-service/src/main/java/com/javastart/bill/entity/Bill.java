package com.javastart.bill.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long billId;
    @Column(name = "account_id")
    private Long accountId;
    private BigDecimal amount;
    @Column(name = "is_default")
    private Boolean isDefault;
    @Column(name = "creation_date")
    private OffsetDateTime creationDate;
    @Column(name = "overdraft_enabled")
    private Boolean overdraftEnabled;
}

