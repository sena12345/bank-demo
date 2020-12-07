package com.sena.bankdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @Column(name = "email",unique = true)
    private String email;
    private String contact;

    @OneToMany(mappedBy = "acc_client")
    private List<BankAccount> bankAccount;
    @OneToMany(mappedBy = "ops_client")
    private List<Operation> operations;
}
