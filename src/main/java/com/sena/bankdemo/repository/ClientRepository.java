package com.sena.bankdemo.repository;

import com.sena.bankdemo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
