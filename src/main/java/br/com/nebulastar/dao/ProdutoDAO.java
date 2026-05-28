/**
 * 
 */
package br.com.nebulastar.dao;

import br.com.nebulastar.dao.generic.GenericDAO;
import br.com.nebulastar.domain.*;

/**
 * @author Nebula Stardust
 */
public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

}
