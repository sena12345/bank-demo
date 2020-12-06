package com.sena.bankdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_account")
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
