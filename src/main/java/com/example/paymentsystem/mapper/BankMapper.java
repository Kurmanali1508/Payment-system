package com.example.paymentsystem.mapper;

import com.example.paymentsystem.dto.BankDto;
import com.example.paymentsystem.entity.Bank;

public interface BankMapper {
    BankDto toBankDto(Bank bank);
}