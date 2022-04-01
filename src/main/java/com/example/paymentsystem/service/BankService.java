package com.example.paymentsystem.service;

import com.example.paymentsystem.entity.Bank;

import java.util.List;

public interface BankService {
    Bank getById(Long id);
    List<Bank> getAll();
    Bank save(Bank bank);
}