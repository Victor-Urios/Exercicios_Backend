/**
 * 
 */
package br.com.nebulastar.dao.jpa;

import br.com.nebulastar.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.nebulastar.domain.jpa.ClienteJpa;

/**
 * Created by Nebula Stardust
 */
public class ClienteJpaDAO extends GenericJpaDB1DAO<ClienteJpa, Long> implements IClienteJpaDAO<ClienteJpa> {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
