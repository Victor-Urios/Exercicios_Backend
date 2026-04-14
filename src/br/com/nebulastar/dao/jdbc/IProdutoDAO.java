package br.com.nebulastar.dao.jdbc;

import br.com.nebulastar.domain.Produto;

import java.util.List;

/**
 * Created by Nebula Stardust
 */
public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;

    public List<Produto> consultarTodos() throws Exception;
}
