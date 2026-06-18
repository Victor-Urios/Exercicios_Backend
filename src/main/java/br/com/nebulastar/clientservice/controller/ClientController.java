package br.com.nebulastar.clientservice.controller;

import br.com.nebulastar.clientservice.dto.ClientRequestDTO;
import br.com.nebulastar.clientservice.dto.ClientResponseDTO;
import br.com.nebulastar.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clients", description = "Sistema CRUD e de busca de clientes")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Crie um novo cliente!",
            description = "Ele valida o payload então tenha certeza que o email já não está em uso!"
                    + "então ele criará um novo cliente no DB")
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO request) {
        ClientResponseDTO created = clientService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Achar um cliente por ID",
            description = "Retorna 404 se não houver cliente algum com este ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(
            @Parameter(description = "Utiliza-se o sequencial do mongo por ex:", example = "65f1a2b3c4d5e6f7a8b9c0d1")
            @PathVariable String id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @Operation(summary = "Listar ou buscar clientes",
            description = "Retornará todos clientes se o parametro 'search' estiver vazio  "
                    + "Quando é colocado algum parametro seja nome documento ou email ele buscará "
                    + "é case insensitive ou seja, pode por maiusculo e minusculo que acha.")
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll(
            @Parameter(description = "Aqui é o busca tudo.", example = "maria")
            @RequestParam(value = "search", required = false) String search) {
        return ResponseEntity.ok(clientService.findAll(search));
    }

    @Operation(summary = "Update num cliente existente",
            description = "Todos os campos editaveis serão mostrados aqui erro 404 se não houver cliente com id"
                    + "ou 409 se o email no cliente atualizado já estiver em uso.")
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(
            @Parameter(description = "id do mongoDb do cliente por ex:", example = "65f1a2b3c4d5e6f7a8b9c0d1")
            @PathVariable String id,
            @Valid @RequestBody ClientRequestDTO request) {
        return ResponseEntity.ok(clientService.update(id, request));
    }

    @Operation(summary = "Deleta o cliente",
            description = "Retorna 404 se não houver cliente com tal ID, "
                    + "Ou 204 caso esteja faltando algo!")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "id do mongoDb do cliente por ex:", example = "65f1a2b3c4d5e6f7a8b9c0d1")
            @PathVariable String id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
