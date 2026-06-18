package br.com.nebulastar.productservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author Nebula Stardust
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de microserviço de produto")
                        .version("0.0.1")
                        .description("Serviço estandalone de gerenciamento de produtos"
                                + "(CRUD + busca), utilizando o mongoDB (productdb). "
                                + "roda idependente do clienteDB"));
    }
}
