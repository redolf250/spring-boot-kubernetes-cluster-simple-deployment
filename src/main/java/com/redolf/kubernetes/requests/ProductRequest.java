package com.redolf.kubernetes.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "This field is required!")
    private String productName;
    @NotBlank(message = "This field is required!")
    private String productDescription;
    @NotNull(message = "This field is required!")
    @Min(value = 10,message = "The minimum value should be greater than or equal to $10!")
    private BigDecimal productPrice;
}
