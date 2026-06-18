package br.com.nebulastar.productservice.service;

import br.com.nebulastar.productservice.dto.ProductRequestDTO;
import br.com.nebulastar.productservice.dto.ProductResponseDTO;
import br.com.nebulastar.productservice.exception.DuplicateResourceException;
import br.com.nebulastar.productservice.exception.ResourceNotFoundException;
import br.com.nebulastar.productservice.model.Product;
import br.com.nebulastar.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/**
 * 
 * @author Nebula Stardust
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductResponseDTO create(ProductRequestDTO request) {
        productRepository.findBySku(request.getSku()).ifPresent(existing -> {
            throw new DuplicateResourceException(
                    "um produto com a Unidade de Manutenção de Estoque'" + request.getSku() + "' já existe");
        });

        LocalDateTime now = LocalDateTime.now();

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .sku(request.getSku())
                .category(request.getCategory())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .createdAt(now)
                .updatedAt(now)
                .build();

        Product saved = productRepository.save(product);
        return toResponseDTO(saved);
    }

    public ProductResponseDTO findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com o id: " + id +  "Não encontrado"));
        return toResponseDTO(product);
    }

    public List<ProductResponseDTO> findAll(String term) {
        List<Product> products = (term == null || term.isBlank())
                ? productRepository.findAll()
                : productRepository.search(term);

        return products.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public ProductResponseDTO update(String id, ProductRequestDTO request) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com o id: " + id +  "Não encontrado"));

        productRepository.findBySku(request.getSku()).ifPresent(other -> {
            if (!other.getId().equals(id)) {
                throw new DuplicateResourceException(
                		 "um produto com a Unidade de Manutenção de Estoque'" + request.getSku() + "' já existe");
            }
        });

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setSku(request.getSku());
        existing.setCategory(request.getCategory());
        existing.setPrice(request.getPrice());
        existing.setStockQuantity(request.getStockQuantity());
        existing.setUpdatedAt(LocalDateTime.now());

        Product saved = productRepository.save(existing);
        return toResponseDTO(saved);
    }

    public void delete(String id) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com o id: " + id +  "Não encontrado"));
        productRepository.delete(existing);
    }

    private ProductResponseDTO toResponseDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .sku(product.getSku())
                .category(product.getCategory())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
