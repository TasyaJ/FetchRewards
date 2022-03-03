package com.example.frewards.controller;

import com.example.frewards.model.Transactions;
import com.example.frewards.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @PostMapping("/addtransactions")
    public Transactions addTransactions(@RequestBody Transactions transactions){
        transactions = transactionsRepository.save(transactions);

        return transactions;
    }


    @GetMapping("/gettransactions")
    public Iterable<Transactions> findAll(){
        return transactionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transactions> getTransactionById(@PathVariable Long id){
        return transactionsRepository.findById(id);
    }






}
