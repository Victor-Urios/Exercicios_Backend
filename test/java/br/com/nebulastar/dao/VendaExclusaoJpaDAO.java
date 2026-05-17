/**
 * 
 */
package br.com.nebulastar.dao;

import br.com.nebulastar.dao.generic.jpa.GenericJpaDB1DAO;
import br.com.nebulastar.dao.jpa.IVendaJpaDAO;
import br.com.nebulastar.domain.jpa.VendaJpa;
import br.com.nebulastar.exceptions.DAOException;
import br.com.nebulastar.exceptions.TipoChaveNaoEncontradaException;

/**
 * Created by Nebula Stardust
 */
public class VendaExclusaoJpaDAO extends GenericJpaDB1DAO<VendaJpa, Long> implements IVendaJpaDAO {

	public VendaExclusaoJpaDAO() {
		super(VendaJpa.class);
	}

	@Override
	public void finalizarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public void cancelarVenda(VendaJpa venda) throws TipoChaveNaoEncontradaException, DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public VendaJpa consultarComCollection(Long id) {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

}
