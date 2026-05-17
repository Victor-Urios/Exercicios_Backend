/**
 * 
 */
package br.com.nebulastar.dao.jpa;

import br.com.nebulastar.dao.generic.jpa.GenericJpaDB2DAO;
import br.com.nebulastar.domain.jpa.ClienteJpa;

/**
 * Created by Nebula Stardust
 */
public class ClienteJpaDB2DAO extends GenericJpaDB2DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDB2DAO() {
		super(ClienteJpa.class);
	}

}
