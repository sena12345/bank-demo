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
public class Operation {
    @Id
    @GeneratedValue
    private int id;
    private int type;
    private long amount;
    private String doneAt;
    @JsonIgnore
    @ManyToOne
    private Client ops_client;

}
