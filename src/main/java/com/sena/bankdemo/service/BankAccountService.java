package com.sena.bankdemo.service;

import com.sena.bankdemo.entity.BankAccount;
import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository accountRepository;

    public long openAccount(int id,BankAccount bankAccount){
        Client client = new Client();
        client.setId(id);
        bankAccount.setAcc_client(client);
        bankAccount.setCreatedAt(LocalDate.now().toString());
        System.out.println("Current id: "+bankAccount.getAcc_client());
        return accountRepository.save(bankAccount).getNumber();
    }

    public List<BankAccount> listAllAccount(){
        return accountRepository.findAll();
    }
    public boolean closeAccount(BankAccount account){
        account.setStatus(!account.isStatus());
        return  accountRepository.save(account).isStatus();
    }

    public BankAccount consultAccount(long number){
        return accountRepository.findById(number).orElse(null);
    }

    public List<BankAccount> listClientAccounts(int clientId){
        return  accountRepository.findAllByClientId(clientId);

    }


}
