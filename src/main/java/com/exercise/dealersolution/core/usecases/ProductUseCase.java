package com.exercise.dealersolution.core.usecases;

import com.exercise.dealersolution.core.entities.Product;
import com.exercise.dealersolution.core.port.ProductRepository;

import javax.inject.Named;
import java.util.List;

@Named
public class ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> retrieveAllProducts(){

        return productRepository.findAll();
    }
}
