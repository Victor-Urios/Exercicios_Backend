package test.br.com.nebulastar.dao;

import br.com.nebulastar.dao.IProdutoDAO;
import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * Created by Nebula Stardust
 */
public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(String valor) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return null;
    }

}
