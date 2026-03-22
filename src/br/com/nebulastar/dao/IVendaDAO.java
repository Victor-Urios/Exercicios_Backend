package br.com.nebulastar.dao;

import br.com.nebulastar.dao.generic.IGenericDAO;
import br.com.nebulastar.domain.Venda;
import br.com.nebulastar.exceptions.TipoChaveNaoEncontradaException;

/**
 * Created by Nebula Stardust
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
