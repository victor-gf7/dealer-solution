package com.exercise.dealersolution.core.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.exercise.dealersolution.core.enums.StatusEnum;

public class Product {

  private Long id;

  private String description;

  private StatusEnum status;

  private BigDecimal price;

  private Integer quantity;

  private Date deadline;

  public Product(Long id, String description, StatusEnum status, BigDecimal price, Integer quantity, Date deadline) {
    this.id = id;
    this.description = description;
    this.status = status;
    this.price = price;
    this.quantity = quantity;
    this.deadline = deadline;
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
