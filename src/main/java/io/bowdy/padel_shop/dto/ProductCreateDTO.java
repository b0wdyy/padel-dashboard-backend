package io.bowdy.padel_shop.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    private String imageUrl;

    @NotNull(message = "Stock quantity is required")
    @PositiveOrZero(message = "Stock quantity must not be negative")
    private Integer stockQuantity;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotBlank(message = "SKU is required")
    private String sku;
} 
