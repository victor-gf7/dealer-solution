package com.exercise.dealersolution.applicartion.controller;

import com.exercise.dealersolution.applicartion.controller.dto.ProductResponse;
import com.exercise.dealersolution.core.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

import com.exercise.dealersolution.adapters.service.ProductService;
import com.exercise.dealersolution.exception.ProdutoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dealer")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public ResponseEntity<List<ProductResponse>> retrieveAll() {
    List<Product> products =  productService.retrieveAllProducts();

    return ResponseEntity.ok(products.stream().map(ProductResponse::of).collect(Collectors.toList()));
  }
}
