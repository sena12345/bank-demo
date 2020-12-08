package com.sena.bankdemo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sena.bankdemo.entity.BankAccount;
import com.sena.bankdemo.entity.Client;
import com.sena.bankdemo.entity.Operation;
import com.sena.bankdemo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping("api/operation/deposit/{amount}")
    public Operation deposit(@PathVariable("amount") long amount, @RequestBody Map<String,String> map){
        BankAccount account = new BankAccount();
        account.setNumber(Long.parseLong(map.get("number")));
        return operationService.deposit(amount,account);
    }

    @PostMapping("api/operation/withdraw/{amount}")
    public Operation withdraw(@PathVariable("amount") long amount, @RequestBody Map<String,String> map){
        BankAccount account = new BankAccount();
        account.setNumber(Long.parseLong(map.get("number")));
        return operationService.withdraw(amount,account);
    }

    @RequestMapping(value = "api/operation/transfer/{amount}", method = RequestMethod.POST)
    @ResponseBody
    public Operation transfer(@PathVariable("amount") long amount,@RequestBody Map<String,BankAccount> bankAccount){

        BankAccount from = bankAccount.get("from");
        BankAccount to =  bankAccount.get("to");

        return operationService.transfer(amount,from,to);
    }

    @PostMapping("api/operation/transactions/")
    public List<Operation> getAllTransaction(@RequestBody Map<String,String> map){
        int type = Integer.parseInt(map.get("type"));
        String fromDate = map.get("from");
        String toDate = map.get("to");
        return  operationService.getAllTransaction(type,fromDate,toDate);
    }

}
