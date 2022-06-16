package com.mavericbankapp.repository;

import com.mavericbankapp.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface AccountRepository extends MongoRepository<Account, String> {

        @Query("{customerId:'?0'}")
        Account findAccountByCustomerId(String customerId);

        @Query(value="{category:'?0'}", fields="{'type' : 1, 'customerId' : 1}")
        List<Account> findAll(String category);
}
