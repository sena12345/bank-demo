package com.sena.bankdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private long balance;

    @JsonIgnore
    @ManyToOne
    private Client acc_client;

}
