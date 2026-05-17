/**
 * 
 */
package br.com.nebulastar.dao.jpa;

import br.com.nebulastar.dao.generic.jpa.GenericJpaDB3DAO;
import br.com.nebulastar.domain.jpa.ClienteJpa2;

/**
 * Created by Nebula Stardust
 */
public class ClienteJpaDB3DAO extends GenericJpaDB3DAO<ClienteJpa2, Long> implements IClienteJpaDAO<ClienteJpa2> {

	public ClienteJpaDB3DAO() {
		super(ClienteJpa2.class);
	}

}
