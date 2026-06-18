package br.com.nebulastar.clientservice;

import br.com.nebulastar.clientservice.dto.ClientRequestDTO;
import br.com.nebulastar.clientservice.dto.ClientResponseDTO;
import br.com.nebulastar.clientservice.exception.DuplicateResourceException;
import br.com.nebulastar.clientservice.exception.ResourceNotFoundException;
import br.com.nebulastar.clientservice.model.Client;
import br.com.nebulastar.clientservice.repository.ClientRepository;
import br.com.nebulastar.clientservice.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private ClientRequestDTO requestDTO;

    @BeforeEach // testes..
    void setUp() {
        requestDTO = ClientRequestDTO.builder()
                .name("Maria Silva")
                .email("maria.silva@example.com")
                .phone("+55 11 91234-5678")
                .document("123.456.789-00")
                .address(ClientRequestDTO.AddressDTO.builder()
                        .street("Rua das Flores, 100")
                        .city("Sao Paulo")
                        .state("SP")
                        .zipCode("01000-000")
                        .country("Brazil")
                        .build())
                .build();
    }

    @Test
    void criarEPersistirComEmailUnico() {
        when(clientRepository.findByEmail(requestDTO.getEmail())).thenReturn(Optional.empty());
        when(clientRepository.save(any(Client.class))).thenAnswer(invocation -> {
            Client toSave = invocation.getArgument(0);
            toSave.setId("generated-id-123");
            return toSave;
        });

        ClientResponseDTO result = clientService.create(requestDTO);

        assertThat(result.getId()).isEqualTo("generated-id-123");
        assertThat(result.getName()).isEqualTo("Maria Silva");
        assertThat(result.getEmail()).isEqualTo("maria.silva@example.com");
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    void criarEDarErroDuplicato() {
        Client existing = Client.builder().id("existing-id").email(requestDTO.getEmail()).build();
        when(clientRepository.findByEmail(requestDTO.getEmail())).thenReturn(Optional.of(existing));

        assertThatThrownBy(() -> clientService.create(requestDTO))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessageContaining(requestDTO.getEmail());

        verify(clientRepository, never()).save(any(Client.class));
    }

    @Test
    void procurarEDarErroIdNaoExistente() {
        when(clientRepository.findById("missing-id")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> clientService.findById("missing-id"))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("missing-id");
    }
}
