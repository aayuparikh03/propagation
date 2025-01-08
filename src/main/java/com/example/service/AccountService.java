package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
//import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateBalanceRequired(int accountId,Double ammount){
        Account account=accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance()+ammount);
        accountRepository.save(account);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBalanceRequiresNew(int accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void updateBalanceNested(int accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateBalanceSupports(int accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateBalanceNotSupported(int accountId, Double amount) {
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
