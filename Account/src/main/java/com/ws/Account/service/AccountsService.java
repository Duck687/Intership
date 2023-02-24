package com.ws.Account.service;


import com.ws.Account.models.Accounts;
import com.ws.Account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Accounts> getAllAccounts() {
        return (List<Accounts>) accountRepository.findAll();
    }

    public Accounts getAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    public void saveOrUpdateAccount(Accounts account) {
        accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}