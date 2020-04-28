package com.marcobehler.springmvcarticle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Transaction {


    private LocalDateTime occurred;

    private String description;

    private Integer id;

    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy hh:mm")
    public LocalDateTime getOccurred() {
        return occurred;
    }

    public void setOccurred(LocalDateTime occurred) {
        this.occurred = occurred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Transaction(LocalDateTime occurred, String description, Integer id, Integer amount) {
        this.occurred = occurred;
        this.description = description;
        this.id = id;
        this.amount = amount;
    }

    public static void main(String[] args) throws JsonProcessingException {

        List<Transaction> tx = Arrays.asList(new Transaction(LocalDateTime.now(), "McDonalds", 1, 10), new Transaction(LocalDateTime.now(), "Burger King", 2, 15));

        System.out.println(new ObjectMapper()   .registerModule(new JSR310Module()).writeValueAsString(tx));
    }
}
