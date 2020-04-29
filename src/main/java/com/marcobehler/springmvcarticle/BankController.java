package com.marcobehler.springmvcarticle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BankController {

    @GetMapping("/transactions/{userId}")
    public List<Transaction> transactions(String userId) {

        // find transaction by user
        // List<Transaction> = dao.findByUserId(userId);

        List<Transaction> transactions = Collections.emptyList();
        return transactions;
    }
}
