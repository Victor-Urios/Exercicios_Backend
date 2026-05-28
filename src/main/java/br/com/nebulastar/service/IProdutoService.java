/**
 * 
 */
package br.com.nebulastar.service;

import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.exceptions.DAOException;
import br.com.nebulastar.services.generic.IGenericService;

/**
 * @author Nebula Stardust
 */
public interface IProdutoService extends IGenericService<Produto, Long> {

	Produto buscarPorCDB(Long cdb) throws DAOException;

}
