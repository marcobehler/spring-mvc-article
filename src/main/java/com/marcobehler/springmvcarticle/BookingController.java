package com.marcobehler.springmvcarticle;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @PostMapping("/transactions")
    public Transaction transaction(@RequestBody TransactionDto dto) { // <1>
        // do something with the dto..create the booking..convert it to a transaction
        Transaction transaction = null;
        return transaction;
    }
}
