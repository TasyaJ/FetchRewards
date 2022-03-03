package com.example.frewards.controller;

import com.example.frewards.model.Transactions;
import com.example.frewards.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionsController {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @PostMapping("/addtransactions")
    public Transactions addTransactions(@RequestBody Transactions transactions){
        transactionsRepository.save(transactions);
        return transactions;
    }



    @GetMapping("/gettransactions")
    public List<Transactions> getAll(){
        return transactionsRepository.findAll();
    }



}
