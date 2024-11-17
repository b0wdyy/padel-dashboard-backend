package io.bowdy.padel_shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import io.bowdy.padel_shop.entity.Category;
import io.bowdy.padel_shop.entity.Product;
import io.bowdy.padel_shop.repository.CategoryRepository;
import io.bowdy.padel_shop.repository.ProductRepository;
import io.bowdy.padel_shop.dto.ProductCreateDTO;
import io.bowdy.padel_shop.exception.ResourceNotFoundException;
import io.bowdy.padel_shop.exception.DuplicateResourceException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Transactional
  public Product createProduct(ProductCreateDTO productDTO) {
    // Check if category exists
    Category category = categoryRepository.findById(productDTO.getCategoryId())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Category not found with id: " + productDTO.getCategoryId()));

    // Check if SKU is unique
    if (productRepository.existsBySku(productDTO.getSku())) {
      throw new DuplicateResourceException(
          "Product with SKU " + productDTO.getSku() + " already exists");
    }

    // Create new product
    Product product = new Product();
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setImageUrl(productDTO.getImageUrl());
    product.setStockQuantity(productDTO.getStockQuantity());
    product.setBrand(productDTO.getBrand());
    product.setCategory(category);
    product.setSku(productDTO.getSku());

    return productRepository.save(product);
  }

  public List<Product> getProductsByCategory(String categoryName) {
    Category category = categoryRepository.findByName(categoryName);
    return productRepository.findByCategory(category);
  }
}
