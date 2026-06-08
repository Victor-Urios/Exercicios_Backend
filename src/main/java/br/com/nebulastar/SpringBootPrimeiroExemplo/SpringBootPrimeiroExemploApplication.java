package br.com.nebulastar.SpringBootPrimeiroExemplo;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.repository.IClienteRepository;

/**
 * @author Nebula Stardust
 */

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.nebulastar.repository")
@EntityScan(basePackages = "br.com.nebulastar.*")
@ComponentScan(basePackages = "br.com.nebulastar")
public class SpringBootPrimeiroExemploApplication implements CommandLineRunner {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(SpringBootPrimeiroExemploApplication.class);
	
	private IClienteRepository repository;
	
    public SpringBootPrimeiroExemploApplication(IClienteRepository repository) {
        this.repository = repository;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPrimeiroExemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Produto prod = createProduto();
		repository.save(prod);
	}
	
	private Produto createProduto() {
		return Produto.builder()
				.nome("Monitor")
				.valor(new BigDecimal("50.50"))
				.descricao("Monitor novinho em folha!")
				.quantidade(20L)
				.build();
	}

}
