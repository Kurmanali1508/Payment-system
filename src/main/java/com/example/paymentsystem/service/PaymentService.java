package com.example.paymentsystem.service;

import com.example.paymentsystem.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment getById(Long id);
    List<Payment> getAll();
    Payment save(Payment payment);
}