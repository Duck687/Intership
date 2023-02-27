package com.ws.account.controller;

import com.ws.account.service.AccountsService;
import com.ws.account.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountsService accountService;

    @GetMapping("")
    public List<Accounts> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id) {
        Accounts account = accountService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public void createAccount(@RequestBody Accounts account) {
       accountService.saveOrUpdateAccount(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody Accounts account) {
        accountService.saveOrUpdateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
       accountService.deleteAccount(id);
    }
}