package br.com.nebulastar.dao.jdbc;

import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.domain.Produto;

import java.util.List;

/**
 * Created by Nebula Stardust
 */
public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente clienteBD) throws Exception;

    public List<Cliente> consultarTodos() throws Exception;

}
