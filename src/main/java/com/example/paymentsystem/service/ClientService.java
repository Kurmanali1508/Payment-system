package com.example.paymentsystem.service;

import com.example.paymentsystem.entity.Client;

import java.util.List;

public interface ClientService {
    Client getById(Long id);
    List<Client> getAll();
    Client save(Client client);
}