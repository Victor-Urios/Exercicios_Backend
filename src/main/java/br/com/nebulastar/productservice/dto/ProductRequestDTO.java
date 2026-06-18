package br.com.nebulastar.productservice.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 * 
 * @author Nebula Stardust
 */
//DTO = data transfer object
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "nome é obrigatório")
    private String name;

    @NotBlank(message = "descrição é obrigatória")
    private String description;

    @NotBlank(message = "Unidade de Manutenção de Estoque é obrigatória")
    private String sku;

    @NotBlank(message = "categoria é obrigatória")
    private String category;

    @NotNull(message = "preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "Preço tem que ser 0 ou maior")
    private BigDecimal price;

    @NotNull(message = "stockQuantity is required")
    @Min(value = 0, message = "stockQuantity cannot be negative")
    private Integer stockQuantity;
}
