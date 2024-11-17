package io.bowdy.padel_shop.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private String imageUrl;
  private Integer stockQuantity;
  private String brand;
  private String category;
  private String sku;
}
