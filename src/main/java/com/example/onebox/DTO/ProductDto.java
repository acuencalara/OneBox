package com.example.onebox.DTO;

import com.example.onebox.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final String description;
    private final BigDecimal amount;
}