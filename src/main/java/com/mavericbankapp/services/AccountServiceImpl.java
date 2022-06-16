package com.mavericbankapp.services;
import com.mavericbankapp.model.Account;
import com.mavericbankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository repository;
    AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }
    public Account createAccount(Account account) {
        return repository.save(account);
    }

}
