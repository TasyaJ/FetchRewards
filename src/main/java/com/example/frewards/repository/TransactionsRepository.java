package com.example.frewards.repository;

import com.example.frewards.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository{

    public List<Transactions> findAll();

    public Transactions get(Long id);

    public boolean save(Transactions transactions);
}
