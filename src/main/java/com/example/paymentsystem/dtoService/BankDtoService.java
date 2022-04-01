package com.example.paymentsystem.dtoService;

import com.example.paymentsystem.dto.BankDto;
import com.example.paymentsystem.dto.CreateBankDto;
import com.example.paymentsystem.dto.UpdateBankDto;

import java.util.List;

public interface BankDtoService {
    BankDto getById(Long id);
    List<BankDto> getAll();
    BankDto create(CreateBankDto createBankDto);
    BankDto update(Long id, UpdateBankDto updateBankDto);
}