package com.sena.bankdemo.service;

import com.sena.bankdemo.Utils;
import com.sena.bankdemo.entity.BankAccount;
import com.sena.bankdemo.entity.Operation;
import com.sena.bankdemo.repository.BankAccountRepository;
import com.sena.bankdemo.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private BankAccountRepository bankAccount;

    public Operation deposit(long amount, BankAccount account){

        BankAccount existingAccount =  bankAccount.getOne(account.getNumber());
        existingAccount.setBalance(amount+existingAccount.getBalance());

        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setType(Utils.DEPOSIT.ordinal());
        operation.setOps_client(existingAccount.getAcc_client());
        operation.setDoneAt(LocalDate.now().toString());

        return operationRepository.save(operation);
    }

    public Operation withdraw(long amount, BankAccount account){
        BankAccount existingAccount =  bankAccount.getOne(account.getNumber());
        existingAccount.setBalance(existingAccount.getBalance() - amount);

        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setType(Utils.WITHDRAWAL.ordinal());
        operation.setOps_client(existingAccount.getAcc_client());
        operation.setDoneAt(LocalDate.now().toString());

        return operationRepository.save(operation);

    }

    public Operation transfer(long amount,BankAccount from,BankAccount to){
        BankAccount existingAccountFrom = bankAccount.getOne(from.getNumber());
        existingAccountFrom.setBalance(existingAccountFrom.getBalance() - amount);

        BankAccount existingAccountTo = bankAccount.getOne(to.getNumber());
        existingAccountTo.setBalance(existingAccountTo.getBalance() + amount);


        Operation operation = new Operation();
        operation.setType(Utils.TRANSFER.ordinal());
        operation.setAmount(amount);
        operation.setOps_client(from.getAcc_client());
        operation.setDoneAt(LocalDate.now().toString());
        return operationRepository.save(operation);

    }

    public List<Operation> getAllTransaction(int type,String begin,String end){
       return operationRepository.getAllTransaction(type,begin,end);
    }


}
