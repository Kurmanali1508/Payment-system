package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.repository.ClientRepository;
import com.example.paymentsystem.service.ClientService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultClientService implements ClientService {
    private final ClientRepository clientRepository;

    public DefaultClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client with id " + id + " is not found!"));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}