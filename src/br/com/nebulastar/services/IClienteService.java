package br.com.nebulastar.services;

import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.exceptions.TipoChaveNaoEncontradaException;

/**
 * Created by Nebula Stardust
 */
public interface IClienteService {

    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
