/**
 * 
 */
package br.com.nebulastar.dao.jpa;

import br.com.nebulastar.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.nebulastar.domain.jpa.ProdutoJpa;

/**
 * Created by Nebula Stardust
 */
public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
