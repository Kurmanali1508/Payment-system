package com.example.paymentsystem.repository;

import com.example.paymentsystem.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByUsername(String username);
}