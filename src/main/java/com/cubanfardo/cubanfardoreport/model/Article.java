package com.cubanfardo.cubanfardoreport.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Article {
    @PositiveOrZero(message = "Total is positive value")
    @NotNull(message = "Total is mandatory")
    private Integer total;
    @NotBlank(message = "Name is mandatory")
    private String name;

    public Article(Integer total1, String name1) {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
