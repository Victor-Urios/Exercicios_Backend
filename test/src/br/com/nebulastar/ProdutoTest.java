package src.br.com.nebulastar;

import br.com.nebulastar.dao.jdbc.IProdutoDAO;
import br.com.nebulastar.dao.jdbc.ProdutoDAO;
import br.com.nebulastar.domain.Produto;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Nebula Stardust
 */
public class ProdutoTest {

    @Test
    public void cadastrarProdutoTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Tv 50 Polegadas");
        produto.setCodigo(1);
        produto.setPreco(new BigDecimal("29.99"));

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(String.valueOf(produto.getCodigo()));
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());
        assertEquals(produto.getPreco(), produtoBD.getPreco());

        produto.setNome("Tv 60 Polegadas");
        dao.atualizar(produto);
        Produto produtoBD2 = dao.consultar(String.valueOf(produto.getCodigo()));
        assertEquals(produtoBD2.getNome(), "Tv 60 Polegadas");

        List<Produto> produtos = dao.consultarTodos();
        assertNotNull(produtos);
        assertTrue(!produtos.isEmpty());

        Produto primeiroProduto = produtos.getFirst();
        assertNotNull(primeiroProduto.getCodigo());
        assertNotNull(primeiroProduto.getNome());
        assertNotNull(primeiroProduto.getPreco());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }
}
