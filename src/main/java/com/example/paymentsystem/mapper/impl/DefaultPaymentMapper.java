package com.example.paymentsystem.mapper.impl;

import com.example.paymentsystem.dto.PaymentDto;
import com.example.paymentsystem.entity.Payment;
import com.example.paymentsystem.mapper.ClientMapper;
import com.example.paymentsystem.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaymentMapper implements PaymentMapper {
    private final ClientMapper clientMapper;

    public DefaultPaymentMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public PaymentDto toPaymentDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setCreatedDate(payment.getCreatedDate());
        paymentDto.setStatus(payment.getStatus());

        if (payment.getClient() != null) {
            paymentDto.setClientDto(clientMapper.toClientDto(payment.getClient()));
        }

        return paymentDto;
    }
}