package com.sena.bankdemo.service;

import com.sena.bankdemo.entity.BankAccount;
import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.repository.BankAccountRepository;
import com.sena.bankdemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository accountRepository;

    public long openAccount(BankAccount bankAccount){
        bankAccount.setCreatedAt(LocalDate.now().toString());
        return accountRepository.save(bankAccount).getNumber();
    }

    public List<BankAccount> listAllAccount(){
        return accountRepository.findAll();
    }
    public boolean closeAccount(BankAccount account){
        BankAccount existingAccount = accountRepository.findById(account.getNumber()).orElse(null);
        existingAccount.setStatus(account.isStatus());
        return accountRepository.save(existingAccount).isStatus();
    }

    public BankAccount consultAccount(long number){
        return accountRepository.findById(number).orElse(null);
    }

    public List<BankAccount> listClientAccounts(int clientId){
        return  accountRepository.findAllByClientId(clientId);

    }


}
