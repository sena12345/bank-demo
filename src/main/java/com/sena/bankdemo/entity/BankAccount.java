package com.sena.bankdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class BankAccount {
    @Id
    private long number;
    private boolean status;
    private String createdAt;
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client acc_client;



}
