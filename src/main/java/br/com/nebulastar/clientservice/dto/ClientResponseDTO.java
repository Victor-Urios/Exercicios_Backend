package br.com.nebulastar.clientservice.dto;
/**
 * 
 * @author Nebula Stardust
 */
//DTO = data transfer object
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private AddressDTO address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddressDTO {
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;
    }
}
