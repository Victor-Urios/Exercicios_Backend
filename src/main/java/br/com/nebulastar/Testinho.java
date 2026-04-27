package main.java.br.com.nebulastar;

import main.java.br.com.nebulastar.dao.IProdutoDAO;
import main.java.br.com.nebulastar.dao.ProdutoDAO;
import main.java.br.com.nebulastar.domain.Produto;

/**
 * Created by Nebula Stardust
 */
public class Testinho {

    static void main() {
        IProdutoDAO produtinhoDao = new ProdutoDAO();
        Produto prod =  new Produto();
        prod.setCodigo("A2");
        prod.setDescricao("Curso backend");
        prod.setNome("Ebac Jaava");
        prod.setValor(2500d);
        produtinhoDao.cadastrar(prod);

    }

}


