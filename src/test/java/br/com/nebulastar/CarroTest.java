package test.java.br.com.nebulastar;

import main.java.br.com.nebulastar.dao.AcessoriosDAO;
import main.java.br.com.nebulastar.dao.CarroDAO;
import main.java.br.com.nebulastar.dao.MarcaDAO;
import main.java.br.com.nebulastar.domain.Acessorios;
import main.java.br.com.nebulastar.domain.Carro;
import main.java.br.com.nebulastar.domain.Marca;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Nebula Stardust
 */
public class CarroTest {
    @Test
    public void salvarEListar() {

        CarroDAO dao = new CarroDAO();

        Marca marca = new Marca();
        marca.setNome("Ford");

        Acessorios acessorios = new Acessorios();
        acessorios.setDescricao("Internet Starlink");

        new MarcaDAO().salvar(marca);
        new AcessoriosDAO().salvar(acessorios);

        Carro carro = new Carro();
        carro.setModelo("Maverick");
        carro.setMarca(marca);
        carro.setAcessorio(acessorios);

        new CarroDAO().salvar(carro);

        List<Carro> lista = dao.listarTodos();

        Assert.assertFalse(lista.isEmpty());
    }
}
