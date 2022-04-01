package com.example.paymentsystem.mapper.impl;

import com.example.paymentsystem.dto.BankDto;
import com.example.paymentsystem.entity.Bank;
import com.example.paymentsystem.mapper.BankMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultBankMapper implements BankMapper {
    @Override
    public BankDto toBankDto(Bank bank) {
        BankDto bankDto = new BankDto();

        bankDto.setId(bank.getId());
        bankDto.setName(bank.getName());

        return bankDto;
    }
}