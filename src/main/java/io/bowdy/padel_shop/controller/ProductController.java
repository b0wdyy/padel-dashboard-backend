package io.bowdy.padel_shop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import io.bowdy.padel_shop.entity.Product;
import io.bowdy.padel_shop.service.ProductService;
import io.bowdy.padel_shop.dto.ProductCreateDTO;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.findAll();
    return ResponseEntity.ok(products);
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductCreateDTO productDTO) {
    Product createdProduct = productService.createProduct(productDTO);
    return ResponseEntity.ok(createdProduct);
  }
}
