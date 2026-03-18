package br.com.nebulastar.modulo24.service;
import br.com.nebulastar.modulo24.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nebula Stardust
 */

public class ClienteService implements IClienteService{
    // aqui ele coloca todos os clientes dentro de uma lista de arreio.
    private List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
        clientes.add(new Cliente(1, "João"));
        clientes.add(new Cliente(2, "Maria"));
    }

    @Override// vai buscar pelo nome do cliente a partir do ID
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
// fiz diferente. mas mantive comentado.
//    @Override // vai listrar todos presentes na memoria clientes
//    public List<Cliente> mostrarTodoMundo() {
//        return clientes;
//    }

    @Override // aqui ele vai pegar o nome do cliente e setar um novo caso seja pedido
    public void atualizar(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId() == cliente.getId()) {
                c.setNome(cliente.getNome());
                return;
            }
        }
    }

    @Override
    public void excluir(int id) { // aqui ele simplesmente remove o cliente a partir do ID
        clientes.removeIf(c -> c.getId() == id);
    }
}