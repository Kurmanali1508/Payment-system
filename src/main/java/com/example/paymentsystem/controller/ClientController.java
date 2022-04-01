package com.example.paymentsystem.controller;

import com.example.paymentsystem.dto.ClientDto;
import com.example.paymentsystem.dto.CreateClientDto;
import com.example.paymentsystem.dto.UpdateClientDto;
import com.example.paymentsystem.dtoService.ClientDtoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientDtoService clientDtoService;

    public ClientController(ClientDtoService clientDtoService) {
        this.clientDtoService = clientDtoService;
    }

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable("id") Long id) {
        return clientDtoService.getById(id);
    }

    @GetMapping
    public List<ClientDto> getAll() {
        return clientDtoService.getAll();
    }

    @PostMapping
    public ClientDto create(@RequestBody CreateClientDto createClientDto) {
        return clientDtoService.create(createClientDto);
    }

    @PutMapping("/{clientId}")
    public ClientDto update(@PathVariable("clientId") Long id, @RequestBody UpdateClientDto updateClientDto) {
        return clientDtoService.update(id, updateClientDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientDtoService.delete(id);
    }
}