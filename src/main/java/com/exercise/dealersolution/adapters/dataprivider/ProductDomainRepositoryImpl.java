package com.exercise.dealersolution.adapters.dataprivider;

import com.exercise.dealersolution.adapters.entity.ProductEntity;
import com.exercise.dealersolution.core.entities.Product;
import com.exercise.dealersolution.core.port.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Named
public class ProductDomainRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    public ProductDomainRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public List<Product> findAll() {
        return productJpaRepository.findAll(Sort.by("quantity").ascending()
                .and(Sort.by("price")).ascending()
                .and(Sort.by("deadline")).descending())
                .stream()
                .map(ProductEntity::toDomain)
                .collect(Collectors.toList());
    }
}
