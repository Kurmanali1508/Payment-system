package com.example.paymentsystem.entity;

import com.example.paymentsystem.entity.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "is_deleted", columnDefinition = "boolean default 'false'")
    private boolean isDeleted;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}