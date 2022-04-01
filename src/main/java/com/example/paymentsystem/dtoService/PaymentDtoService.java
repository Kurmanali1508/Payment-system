package com.example.paymentsystem.dtoService;

import com.example.paymentsystem.dto.CreatePaymentDto;
import com.example.paymentsystem.dto.PaymentDto;
import com.example.paymentsystem.dto.UpdatePaymentDto;

import java.util.List;

public interface PaymentDtoService {
    PaymentDto getById(Long id);
    List<PaymentDto> getAll();
    PaymentDto create(CreatePaymentDto createPaymentDto);
    PaymentDto update(Long id, UpdatePaymentDto updatePaymentDto);
    void delete(Long id);
}