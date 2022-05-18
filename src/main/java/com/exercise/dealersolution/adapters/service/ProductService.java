package com.exercise.dealersolution.adapters.service;

import com.exercise.dealersolution.core.entities.Product;
import com.exercise.dealersolution.core.usecases.ProductUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductUseCase productUseCase;

    public ProductService(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    public List<Product> retrieveAllProducts() {
        return productUseCase.retrieveAllProducts();
    }
}
