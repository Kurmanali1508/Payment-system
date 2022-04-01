package com.example.paymentsystem.dtoService.impl;

import com.example.paymentsystem.dto.BankDto;
import com.example.paymentsystem.dto.CreateBankDto;
import com.example.paymentsystem.dto.UpdateBankDto;
import com.example.paymentsystem.dtoService.BankDtoService;
import com.example.paymentsystem.entity.Bank;
import com.example.paymentsystem.mapper.BankMapper;
import com.example.paymentsystem.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultBankDtoService implements BankDtoService {
    private final BankService bankService;
    private final BankMapper bankMapper;

    public DefaultBankDtoService(BankService bankService, BankMapper bankMapper) {
        this.bankService = bankService;
        this.bankMapper = bankMapper;
    }

    @Override
    public BankDto getById(Long id) {
        return bankMapper.toBankDto(bankService.getById(id));
    }

    @Override
    public List<BankDto> getAll() {
        return bankService.getAll()
                .stream()
                .map(bankMapper::toBankDto)
                .collect(Collectors.toList());
    }

    @Override
    public BankDto create(CreateBankDto createBankDto) {
        Bank bank = new Bank();

        bank.setName(createBankDto.getName());

        return bankMapper.toBankDto(bankService.save(bank));
    }

    @Override
    public BankDto update(Long id, UpdateBankDto updateBankDto) {
        Bank bank = bankService.getById(id);

        bank.setName(updateBankDto.getName());

        return bankMapper.toBankDto(bankService.save(bank));
    }
}