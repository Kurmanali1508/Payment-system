package com.example.paymentsystem.dtoService.impl;

import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.dto.CreateClientDto;
import com.example.paymentsystem.dto.UpdateClientDto;
import com.example.paymentsystem.dtoService.ClientDtoService;
import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.mapper.ClientMapper;
import com.example.paymentsystem.service.BankService;
import com.example.paymentsystem.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultClientDtoService implements ClientDtoService {
    private final ClientMapper clientMapper;
    private final ClientService clientService;
    private final BankService bankService;

    public DefaultClientDtoService(ClientMapper clientMapper, ClientService clientService, BankService bankService) {
        this.clientMapper = clientMapper;
        this.clientService = clientService;
        this.bankService = bankService;
    }

    @Override
    public ClientDto getById(Long id) {
        return clientMapper.toClientDto(clientService.getById(id));
    }

    @Override
    public List<ClientDto> getAll() {
        return clientService.getAll()
                .stream()
                .map(clientMapper::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto create(CreateClientDto createClientDto) {
        Client client = new Client();

        client.setUsername(createClientDto.getUsername());
        client.setAccountNumber(createClientDto.getAccountNumber());
        client.setCurrentBalance(createClientDto.getCurrentBalance());
        client.setPassword(createClientDto.getPassword());

        if (createClientDto.getBankId() != null) {
            client.setBank(bankService.getById(createClientDto.getBankId()));
        }

        return clientMapper.toClientDto(clientService.save(client));
    }

    @Override
    public ClientDto update(Long id, UpdateClientDto updateClientDto) {
        Client client = clientService.getById(id);

        client.setUsername(updateClientDto.getUsername());
        client.setAccountNumber(updateClientDto.getAccountNumber());
        client.setCurrentBalance(updateClientDto.getCurrentBalance());
        client.setPassword(updateClientDto.getPassword());

        if (updateClientDto.getBankId() != null) {
            client.setBank(bankService.getById(updateClientDto.getBankId()));
        }

        return clientMapper.toClientDto(clientService.save(client));
    }

    @Override
    public void delete(Long id) {
        Client client = clientService.getById(id);

        client.setDeleted(true);

        clientService.save(client);
    }
}