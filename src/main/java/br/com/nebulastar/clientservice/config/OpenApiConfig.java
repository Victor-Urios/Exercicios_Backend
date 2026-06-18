package br.com.nebulastar.clientservice.config;

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
    public OpenAPI clientServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de serviço de cliente")
                        .version("0.0.1")
                        .description("um microserviço standalone que faz gerenciamento de clientes "
                                + "(CRUD + busca), utilizando o mongodb (clientdb). "));
    }
}
