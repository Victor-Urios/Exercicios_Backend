package br.com.nebulastar.clientservice.service;

import br.com.nebulastar.clientservice.dto.ClientRequestDTO;
import br.com.nebulastar.clientservice.dto.ClientResponseDTO;
import br.com.nebulastar.clientservice.exception.DuplicateResourceException;
import br.com.nebulastar.clientservice.exception.ResourceNotFoundException;
import br.com.nebulastar.clientservice.model.Client;
import br.com.nebulastar.clientservice.repository.ClientRepository;
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
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientResponseDTO create(ClientRequestDTO request) {
        clientRepository.findByEmail(request.getEmail()).ifPresent(existing -> {
            throw new DuplicateResourceException(
                    "Um cliente com o email'" + request.getEmail() + "' Já existe!");
        });

        LocalDateTime now = LocalDateTime.now();

        Client client = Client.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .document(request.getDocument())
                .address(toModelAddress(request.getAddress()))
                .createdAt(now)
                .updatedAt(now)
                .build();

        Client saved = clientRepository.save(client);
        return toResponseDTO(saved);
    }

    public ClientResponseDTO findById(String id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o id: " + id));
        return toResponseDTO(client);
    }

    public List<ClientResponseDTO> findAll(String term) {
        List<Client> clients = (term == null || term.isBlank())
                ? clientRepository.findAll()
                : clientRepository.search(term);

        return clients.stream()
                .map(this::toResponseDTO)
                .toList();
    }


    public ClientResponseDTO update(String id, ClientRequestDTO request) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o id: " + id));

        clientRepository.findByEmail(request.getEmail()).ifPresent(other -> {
            if (!other.getId().equals(id)) {
                throw new DuplicateResourceException(
                        "O cliente com o email:" + request.getEmail() + " Já existe!");
            }
        });

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setPhone(request.getPhone());
        existing.setDocument(request.getDocument());
        existing.setAddress(toModelAddress(request.getAddress()));
        existing.setUpdatedAt(LocalDateTime.now());

        Client saved = clientRepository.save(existing);
        return toResponseDTO(saved);
    }

    public void delete(String id) {
        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente do Id: " + id + "Não encontrado"));
        clientRepository.delete(existing);
    }


    private Client.Address toModelAddress(ClientRequestDTO.AddressDTO dto) {
        if (dto == null) {
            return null;
        }
        return Client.Address.builder()
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .zipCode(dto.getZipCode())
                .country(dto.getCountry())
                .build();
    }

    private ClientResponseDTO.AddressDTO toResponseAddress(Client.Address address) {
        if (address == null) {
            return null;
        }
        return ClientResponseDTO.AddressDTO.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .country(address.getCountry())
                .build();
    }

    private ClientResponseDTO toResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .document(client.getDocument())
                .address(toResponseAddress(client.getAddress()))
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                .build();
    }
}
