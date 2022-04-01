package com.example.paymentsystem.dtoService;

import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.dto.CreateClientDto;
import com.example.paymentsystem.dto.UpdateClientDto;

import java.util.List;

public interface ClientDtoService {
    ClientDto getById(Long id);
    List<ClientDto> getAll();
    ClientDto create(CreateClientDto createClientDto);
    ClientDto update(Long id, UpdateClientDto updateClientDto);
    void delete(Long id);
}