/**
 * 
 */
package br.com.nebulastar.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.nebulastar.dao.IProdutoDAO;
import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.exceptions.DAOException;
import br.com.nebulastar.exceptions.MaisDeUmRegistroException;
import br.com.nebulastar.exceptions.TableException;
import br.com.nebulastar.services.generic.GenericService;

/**
 * @author Nebula Stardust
 */
@Stateless
public class ProdutoService extends GenericService<Produto, Long> implements IProdutoService {
	
	@Inject
	public ProdutoService(IProdutoDAO produtoDAO) {
		super(produtoDAO);
	}

	@Override
	public Produto buscarPorCDB(Long cdb) throws DAOException {
		try {
			return this.dao.consultar(cdb);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
