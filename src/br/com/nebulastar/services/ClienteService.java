package br.com.nebulastar.services;

import br.com.nebulastar.dao.IClienteDAO;
import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.services.generic.GenericService;

/**
 * Created by Nebula Stardust
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }


    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }



}
