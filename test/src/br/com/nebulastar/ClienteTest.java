package src.br.com.nebulastar;

import br.com.nebulastar.dao.jdbc.ClienteDAO;
import br.com.nebulastar.dao.jdbc.IClienteDAO;
import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.domain.Produto;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Nebula Stardust
 */
public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo(1);
        cliente.setNome("Nebula Stardust");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(String.valueOf(cliente.getCodigo()));
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        cliente.setNome("Nebula Stardustzinho");
        dao.atualizar(cliente);
        Cliente clienteBD2 = dao.consultar(String.valueOf(cliente.getCodigo()));
        assertEquals(clienteBD2.getNome(), "Nebula Stardustzinho");

        List<Cliente> clientes = dao.consultarTodos();
        assertNotNull(clientes);
        assertTrue(!clientes.isEmpty());

        Cliente primeiroCliente = clientes.getFirst();
        assertNotNull(primeiroCliente.getId());
        assertNotNull(primeiroCliente.getNome());
        assertNotNull(primeiroCliente.getCodigo());


        Integer qtdDel = dao.excluir(clienteBD);
        assertNotNull(qtdDel);
            }
}
