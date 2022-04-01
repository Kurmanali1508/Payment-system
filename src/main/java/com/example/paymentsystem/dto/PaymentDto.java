package com.example.paymentsystem.dto;

import com.example.paymentsystem.entity.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentDto {
    private Long id;
    private Date createdDate;
    private BigDecimal amount;
    private ClientDto clientDto;
    private Status status;
}