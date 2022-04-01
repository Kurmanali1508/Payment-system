package com.example.paymentsystem.repository;

import com.example.paymentsystem.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}