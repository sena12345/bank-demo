package com.sena.bankdemo.controller;

import com.sena.bankdemo.entity.BankAccount;
import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("api/account/create/{id}")
    public long openAccount(@PathVariable int id, @RequestBody BankAccount bankAccount){
        return bankAccountService.openAccount(id,bankAccount);
    }
    @GetMapping("api/account/accounts")
    public List<BankAccount> getAllAccounts(){
        return bankAccountService.listAllAccount();
    }
    @PostMapping("api/account/close")
    public boolean closeAccount(@RequestBody BankAccount bankAccount){
        return bankAccountService.closeAccount(bankAccount);
    }

    @GetMapping("api/account/consult/{number}")
    public BankAccount consultAccount(@PathVariable long number){
        return bankAccountService.consultAccount(number);
    }

    @GetMapping("api/account/client/{clientId}")
    public List<BankAccount> listClientAccounts(@PathVariable int clientId){
        return bankAccountService.listClientAccounts(clientId);
    }
}
