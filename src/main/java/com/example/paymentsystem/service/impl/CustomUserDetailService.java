package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.entity.Client;
import com.example.paymentsystem.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final ClientRepository clientRepository;

    public CustomUserDetailService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), new ArrayList<>());
    }
}