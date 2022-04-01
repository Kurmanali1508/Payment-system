package com.example.paymentsystem.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePaymentDto {
    private BigDecimal amount;
    private Long clientId;
}