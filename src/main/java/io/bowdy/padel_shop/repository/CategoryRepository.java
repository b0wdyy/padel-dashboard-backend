package io.bowdy.padel_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.bowdy.padel_shop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Category findByName(String name);
}
