package com.exercise.util;

import com.exercise.dealersolution.core.entities.Product;
import com.exercise.dealersolution.core.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.Date;

public class ProductBuilder {

    private Long id;
    private String description;
    private StatusEnum status;
    private BigDecimal price;
    private Integer quantity;
    private Date deadline;

    public ProductBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ProductBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ProductBuilder withStatus(StatusEnum status){
        this.status = status;
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price){
        this.price = price;
        return this;
    }

    public ProductBuilder withQuantity(Integer quantity){
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder withDeadline(Date deadline){
        this.deadline = deadline;
        return this;
    }

    public Product create(){
        return new Product(this.id, this.description, this.status, this.price, this.quantity, this.deadline);
    }

}
