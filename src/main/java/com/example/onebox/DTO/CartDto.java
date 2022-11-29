package com.example.onebox.DTO;

import com.example.onebox.model.Cart;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link Cart} entity
 */
@Data
public class CartDto implements Serializable {
    private final LocalDate creationdDate;
    private final List<Long> productIds;
}