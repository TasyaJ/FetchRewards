package com.example.frewards;

import com.example.frewards.model.Transactions;
import com.example.frewards.repository.TransactionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class FrewardsApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext configurableApplicationContext=
				SpringApplication.run(FrewardsApplication.class, args);

		TransactionsRepository transactionsRepository =
				configurableApplicationContext.getBean(TransactionsRepository.class);


	}

}
