package test.br.com.nebulastar.dao;

import br.com.nebulastar.dao.IClienteDAO;
import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * Created by Nebula Stardust
 */
public class ClienteDaoMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }


}
