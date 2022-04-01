package com.example.paymentsystem.mapper.impl;

import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.mapper.BankMapper;
import com.example.paymentsystem.mapper.ClientMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultClientMapper implements ClientMapper {
    private final BankMapper bankMapper;

    public DefaultClientMapper(BankMapper bankMapper) {
        this.bankMapper = bankMapper;
    }

    @Override
    public ClientDto toClientDto(Client client) {
        ClientDto clientDto = new ClientDto();

        clientDto.setId(client.getId());
        clientDto.setAccountNumber(client.getAccountNumber());
        clientDto.setCurrentBalance(client.getCurrentBalance());
        clientDto.setPassword(client.getPassword());
        clientDto.setUsername(client.getUsername());

        if (client.getBank() != null) {
            clientDto.setBankDto(bankMapper.toBankDto(client.getBank()));
        }

        return clientDto;
    }
}