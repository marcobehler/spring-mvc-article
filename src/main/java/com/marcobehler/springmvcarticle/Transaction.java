package com.marcobehler.springmvcarticle;

import java.time.LocalDateTime;

public class Transaction {

    public LocalDateTime occurred;

    private String description;

    private Integer id;

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
}
