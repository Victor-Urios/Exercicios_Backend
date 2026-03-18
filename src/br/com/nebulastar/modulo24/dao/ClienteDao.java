package br.com.nebulastar.modulo24.dao;

import br.com.nebulastar.modulo24.Cliente;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nebula Stardust
 */
public class ClienteDao implements IClienteDao{

    private Map<Integer, Cliente> clientes = new HashMap<>();

    // ctrl c ctrl v padrão, aqui usando hashmap ao invez do arraylist.
    public ClienteDao() {
        clientes.put(1, new Cliente(1, "Ana"));
        clientes.put(2, new Cliente(2, "Carlos"));
    }

    @Override
    public Cliente buscarPorId(int id) {
        return clientes.get(id);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }

    @Override
    public void excluir(int id) {
        clientes.remove(id);
    }
}
