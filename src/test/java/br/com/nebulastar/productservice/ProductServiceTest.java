package br.com.nebulastar.productservice;

import br.com.nebulastar.productservice.dto.ProductRequestDTO;
import br.com.nebulastar.productservice.dto.ProductResponseDTO;
import br.com.nebulastar.productservice.exception.DuplicateResourceException;
import br.com.nebulastar.productservice.exception.ResourceNotFoundException;
import br.com.nebulastar.productservice.model.Product;
import br.com.nebulastar.productservice.repository.ProductRepository;
import br.com.nebulastar.productservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
/**
 * 
 * @author Nebula Stardust
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private ProductRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        requestDTO = ProductRequestDTO.builder()
                .name("Teclado mecanico")
                .description("Teclado mecanico com switches azuis")
                .sku("KB-87-BLUE")
                .category("Periférico")
                .price(new BigDecimal("249.90"))
                .stockQuantity(50)
                .build();
    }

    @Test
    void testeDePersistenciaESKUunico() {
        when(productRepository.findBySku(requestDTO.getSku())).thenReturn(Optional.empty());
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> {
            Product toSave = invocation.getArgument(0);
            toSave.setId("id-456");
            return toSave;
        });

        ProductResponseDTO result = productService.create(requestDTO);

        assertThat(result.getId()).isEqualTo("id-456");
        assertThat(result.getName()).isEqualTo("Teclado mecanico com switches azuis");
        assertThat(result.getSku()).isEqualTo("KB-87-BLUE");
        assertThat(result.getPrice()).isEqualByComparingTo("249.90");
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testeDeErroComSKUDuplicado() {
        Product existing = Product.builder().id("existing-id").sku(requestDTO.getSku()).build();
        when(productRepository.findBySku(requestDTO.getSku())).thenReturn(Optional.of(existing));

        assertThatThrownBy(() -> productService.create(requestDTO))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessageContaining(requestDTO.getSku());

        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    void findPorIDNaoExistente() {
        when(productRepository.findById("missing-id")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.findById("missing-id"))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("missing-id");
    }
}
