package com.example.paymentsystem.mapper;

import com.example.paymentsystem.dto.PaymentDto;
import com.example.paymentsystem.entity.Payment;

public interface PaymentMapper {
    PaymentDto toPaymentDto(Payment payment);
}