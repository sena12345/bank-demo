package com.sena.bankdemo.repository;

import com.sena.bankdemo.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
    @Query(value = "from BankAccount b where b.acc_client.id = :clientId")
    List<BankAccount> findAllByClientId(@Param("clientId") int clientId);
}
