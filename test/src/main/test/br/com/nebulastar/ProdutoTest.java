package src.main.test.br.com.nebulastar;

import main.java.br.com.nebulastar.dao.ProdutoDAO;
import main.java.br.com.nebulastar.dao.IProdutoDAO;
import main.java.br.com.nebulastar.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Nebula Stardust
 */
public class ProdutoTest {
    private IProdutoDAO produtoDAO;

    public ProdutoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void cadastrar(){
        Produto prod =  new Produto();
        prod.setCodigo("A1");
        prod.setDescricao("PRODUTO TESTE");
        prod.setNome("Produtinho teste");
        prod.setValor(10.25d);
        prod = produtoDAO.cadastrar(prod);

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }
}
