package com.exercise.dealersolution.adapters.entity;

import com.exercise.dealersolution.core.entities.Product;
import com.exercise.dealersolution.core.enums.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.EnumType.STRING;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @Enumerated(STRING)
    private StatusEnum status;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @FutureOrPresent
    @NotNull
    private Date deadline;

    @Deprecated
    public ProductEntity() {
    }

    public ProductEntity(String description,
                         StatusEnum status,
                         BigDecimal price,
                         Integer quantity,
                         Date deadline) {
        this.description = description;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.deadline = deadline;
    }

    public Product toDomain(){
        return new Product(this.id, this.description,this.status, this.price, this.quantity, this.deadline);
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getDeadline() {
        return deadline;
    }
}
