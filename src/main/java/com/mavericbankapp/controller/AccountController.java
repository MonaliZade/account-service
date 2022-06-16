package com.mavericbankapp.controller;


import com.mavericbankapp.model.Account;
import com.mavericbankapp.model.AccountDTO;
import com.mavericbankapp.services.AccountService;
import com.mavericbankapp.services.AccountServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@Component
@RestController
@RequestMapping("/customers/{customerId}")
public class AccountController {
    @Autowired
    ModelMapper modelMapper;
    private final AccountServiceImpl accountService;
    AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        Account account = convertToEntity(accountDTO);
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }
    private Account convertToEntity(AccountDTO accountDTO) {
        return modelMapper.map(accountDTO, Account.class);
    }

}
