package br.com.nebulastar.clientservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author Nebula Stardust
 */
// DTO = data transfer object
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Use um email válido!")
    private String email;

    @NotBlank(message = "telefone é obrigatório ")
    private String phone;

    @NotBlank(message = "Documento CPF-CNPJ é obrigatório")
    private String document;

    @Valid
    private AddressDTO address;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddressDTO {
        @NotBlank(message = "Rua é obrigatória")
        private String street;

        @NotBlank(message = "Cidade é obrigatória")
        private String city;

        @NotBlank(message = "Estado é obrigatório")
        private String state;

        @NotBlank(message = "CEP é obrigatório")
        private String zipCode;

        @NotBlank(message = "país é obrigtório")
        private String country;
    }
}
