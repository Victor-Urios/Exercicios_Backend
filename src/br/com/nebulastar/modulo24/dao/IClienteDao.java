package br.com.nebulastar.modulo24.dao;

import br.com.nebulastar.modulo24.Cliente;

/**
 * Created by Nebula Stardust
 */
public interface IClienteDao {
    Cliente buscarPorId(int id);
    void atualizar(Cliente cliente);
    void excluir(int id);
//    public String salvar();
}
