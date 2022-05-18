package com.exercise.dealersolution.applicartion.controller.dto;

import com.exercise.dealersolution.core.enums.StatusEnum;
import com.exercise.dealersolution.core.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ProductResponse {

    @JsonProperty
    private String description;

    @JsonProperty
    private StatusEnum status;

    @JsonProperty
    private BigDecimal price;

    @JsonProperty
    private Integer quantity;

    @JsonProperty
    private Date deadline;

    @Deprecated
    public ProductResponse() {
    }

    public ProductResponse(String description,
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

    public static ProductResponse of(Product product){
        return new ProductResponse(product.getDescription(),
                product.getStatus(),
                product.getPrice(),
                product.getQuantity(),
                product.getDeadline());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(description, that.description) &&
                status == that.status &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(deadline, that.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, status, price, quantity, deadline);
    }
}
