package br.com.nebulastar.productservice.controller;

import br.com.nebulastar.productservice.dto.ProductRequestDTO;
import br.com.nebulastar.productservice.dto.ProductResponseDTO;
import br.com.nebulastar.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 
 * @author Nebula Stardust
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "operações CRUD e busca em produtos")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Cria um novo produto",
            description = "Valida o payload, assegurando que a Unidade de Manutenção de Estoque já nao esta em uso, "
                    + "então persiste um novo produto no productdb.")
    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request) {
        ProductResponseDTO created = productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Pega um produto pelo ID",
            description = "Retorna 404 se não houver o produto com tal id.")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(
            @Parameter(description = "id do produto dado pelo MongoDB exemplo:", example = "65f1a2b3c4d5e6f7a8b9c0d2")
            @PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @Operation(summary = "Lista ou procura produtos",
            description = "Retorna todos os produtos se não tiver nada na caixa de busca "
                    + "Quando é colocado alguma coisa para pesquisar, fara uma pesquisa case-insensitive "
                    + "coloque nome descrição ou algo que remeta ao produto em estoque")
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll(
            @Parameter(description = "Pesquise algo por ex:", example = "teclado")
            @RequestParam(value = "search", required = false) String search) {
        return ResponseEntity.ok(productService.findAll(search));
    }

    @Operation(summary = "Atualiza/edita um produto existente.",
            description = "Troca completamente as casas editaveis, Returna 404 se "
                    + "o id nao existe, ou 409 se a Unidade de Manutenção de Estoque já estiver em uso")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @Parameter(description = "id do mongoDB do produto ex:", example = "65f1a2b3c4d5e6f7a8b9c0d2")
            @PathVariable String id,
            @Valid @RequestBody ProductRequestDTO request) {
        return ResponseEntity.ok(productService.update(id, request));
    }

    @Operation(summary = "Deletar o produto",
            description = "Retorna 404 se o id dado não existir no banco de dados "
                    + "no outro caso 204 No content sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description ="id do mongoDB do produto ex:", example = "65f1a2b3c4d5e6f7a8b9c0d2")
            @PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
