package com.exercise.dealersolution.core.port;

import com.exercise.dealersolution.core.entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
}
