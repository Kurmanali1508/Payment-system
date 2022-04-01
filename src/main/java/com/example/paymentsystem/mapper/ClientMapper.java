package com.example.paymentsystem.mapper;

import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.entity.Client;

public interface ClientMapper {
    ClientDto toClientDto(Client client);
}