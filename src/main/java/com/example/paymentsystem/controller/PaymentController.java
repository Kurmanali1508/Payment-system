package com.example.paymentsystem.controller;

import com.example.paymentsystem.dto.CreatePaymentDto;
import com.example.paymentsystem.dto.PaymentDto;
import com.example.paymentsystem.dto.UpdatePaymentDto;
import com.example.paymentsystem.dtoService.PaymentDtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentDtoService paymentDtoService;

    public PaymentController(PaymentDtoService paymentDtoService) {
        this.paymentDtoService = paymentDtoService;
    }

    @GetMapping("/{id}")
    public PaymentDto getById(@PathVariable("id") Long id) {
        return paymentDtoService.getById(id);
    }

    @GetMapping
    public List<PaymentDto> getAll() {
        return paymentDtoService.getAll();
    }

    @PostMapping
    public PaymentDto create(@RequestBody CreatePaymentDto createPaymentDto) {
        return paymentDtoService.create(createPaymentDto);
    }

    @PutMapping("/{paymentId}")
    public PaymentDto update(@PathVariable("paymentId") Long id, @RequestBody UpdatePaymentDto updatePaymentDto) {
        return paymentDtoService.update(id, updatePaymentDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        paymentDtoService.delete(id);
    }
}