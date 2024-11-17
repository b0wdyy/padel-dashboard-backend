package io.bowdy.padel_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.bowdy.padel_shop.entity.Category;
import io.bowdy.padel_shop.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByActiveTrue();

  List<Product> findByCategory(Category category);

  List<Product> findByBrand(String brand);

  Product findBySku(String sku);

  Boolean existsBySku(String sku);
}
