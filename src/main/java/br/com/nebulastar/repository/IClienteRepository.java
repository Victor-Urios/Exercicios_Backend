package br.com.nebulastar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nebulastar.domain.Produto;

/**
 * @author Nebula Stardust
 */
@Repository
public interface IClienteRepository extends CrudRepository<Produto, Long> {

}
