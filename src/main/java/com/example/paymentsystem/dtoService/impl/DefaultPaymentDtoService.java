package com.example.paymentsystem.dtoService.impl;

import com.example.paymentsystem.dto.CreatePaymentDto;
import com.example.paymentsystem.dto.PaymentDto;
import com.example.paymentsystem.dto.UpdatePaymentDto;
import com.example.paymentsystem.dtoService.PaymentDtoService;
import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.entity.Payment;
import com.example.paymentsystem.entity.enums.Status;
import com.example.paymentsystem.mapper.PaymentMapper;
import com.example.paymentsystem.service.ClientService;
import com.example.paymentsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultPaymentDtoService implements PaymentDtoService {
    private final PaymentMapper paymentMapper;
    private final PaymentService paymentService;
    private final ClientService clientService;

    public DefaultPaymentDtoService(PaymentMapper paymentMapper, PaymentService paymentService, ClientService clientService) {
        this.paymentMapper = paymentMapper;
        this.paymentService = paymentService;
        this.clientService = clientService;
    }

    @Override
    public PaymentDto getById(Long id) {
        return paymentMapper.toPaymentDto(paymentService.getById(id));
    }

    @Override
    public List<PaymentDto> getAll() {
        return paymentService.getAll()
                .stream()
                .map(paymentMapper::toPaymentDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto create(CreatePaymentDto createPaymentDto) {
        Payment payment = new Payment();

        Client client = clientService.getById(createPaymentDto.getClientId());

        if (client.getCurrentBalance().compareTo(createPaymentDto.getAmount()) >= 0) {
            client.setCurrentBalance((client.getCurrentBalance()).subtract(createPaymentDto.getAmount()));

            clientService.save(client);

            payment.setStatus(Status.SUCCESS);
        } else {
            payment.setStatus(Status.FAILED);
        }

        payment.setAmount(createPaymentDto.getAmount());
        payment.setCreatedDate(new Date());

        if (createPaymentDto.getClientId() != null) {
            payment.setClient(clientService.getById(createPaymentDto.getClientId()));
        }

        return paymentMapper.toPaymentDto(paymentService.save(payment));
    }

    @Override
    public PaymentDto update(Long id, UpdatePaymentDto updatePaymentDto) {
        Payment payment = paymentService.getById(id);

        payment.setAmount(updatePaymentDto.getAmount());
        payment.setCreatedDate(new Date());

        if (updatePaymentDto.getClientId() != null) {
            payment.setClient(clientService.getById(updatePaymentDto.getClientId()));
        }

        return paymentMapper.toPaymentDto(paymentService.save(payment));
    }

    @Override
    public void delete(Long id) {
        Payment payment = paymentService.getById(id);

        payment.setDeleted(true);

        paymentService.save(payment);
    }
}