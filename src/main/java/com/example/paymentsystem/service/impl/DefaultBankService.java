package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.entity.Bank;
import com.example.paymentsystem.repository.BankRepository;
import com.example.paymentsystem.service.BankService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultBankService implements BankService {
    private final BankRepository bankRepository;

    public DefaultBankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank getById(Long id) {
        return bankRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bank with id " + id + " is not found!"));
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }
}