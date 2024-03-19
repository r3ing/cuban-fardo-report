package com.cubanfardo.cubanfardoreport.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Article {
    @PositiveOrZero(message = "Quantity is positive value")
    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;
    @NotBlank(message = "Product is mandatory")
    private String product;

    public Article(Integer quantity, String product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


}
