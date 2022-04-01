package com.example.paymentsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private boolean isDeleted;

    @ManyToOne
    private Bank bank;
}