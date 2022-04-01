package com.example.paymentsystem.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientDto {
    private Long id;
    private String username;
    private String password;
    private BigDecimal currentBalance;
    private String accountNumber;
    private BankDto bankDto;
}