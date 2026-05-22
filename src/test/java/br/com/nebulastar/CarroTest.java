package br.com.nebulastar;

import br.com.nebulastar.dao.CarroDAO;
import br.com.nebulastar.domain.Acessorios;
import br.com.nebulastar.domain.Carro;
import br.com.nebulastar.domain.Marca;
import org.junit.Assert;
import org.testng.annotations.Test;

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
        acessorios.setDescricao("Airbag");

        Carro carro = new Carro();
        carro.setModelo("Focus");
        carro.setMarca(marca);
        carro.setAcessorio(acessorios);

        dao.salvar(carro);

        List<Carro> lista = dao.listarTodos();

        Assert.assertFalse(lista.isEmpty());
    }
}
