package com.example.frewards.repository;

import com.example.frewards.model.Transactions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionsRepo implements TransactionsRepository{

    private JdbcTemplate jdbcTemplate;

    public TransactionsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean save(Transactions transactions) {
        String sql = "INSERT INTO transactions (id, payer, points, timestamp) VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql,transactions.getId(), transactions.getPayer(), transactions.getPoints(), transactions.getTimestamp()) == 1;
    }

    @Override
    public List<Transactions> findAll() {
        List<Transactions> transactions = new ArrayList<>();

        String sql = "SELECT * FROM transactions";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Transactions transaction = mapRowToTransactions(results);
            transactions.add(transaction);
        }
        return transactions;
    }

    @Override
    public Transactions get(Long id) {
           Transactions transaction = null;
        String sql = "SELECT * FROM transactions WHERE id = ? ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        while(results.next()) {
            transaction = mapRowToTransactions(results);
        }

        return transaction;
    }

    private Transactions mapRowToTransactions(SqlRowSet rs) {
        Transactions transactions = new Transactions();
        transactions.setId(rs.getLong("id"));
        transactions.setPayer(rs.getString("payer"));
        transactions.setPoints(rs.getInt("points"));
        transactions.setTimestamp(rs.getDate("timestamp"));
        return transactions;
    };

}
