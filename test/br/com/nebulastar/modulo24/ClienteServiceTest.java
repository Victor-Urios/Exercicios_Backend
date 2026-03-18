package br.com.nebulastar.modulo24;
import br.com.nebulastar.modulo24.dao.ClienteDao;
import br.com.nebulastar.modulo24.service.ClienteService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Nebula Stardust
 */
public class ClienteServiceTest {

    private ClienteDao clientedao;
    private ClienteService service;

    @Before
    public void setUp() {
        service = new ClienteService();
        clientedao = new ClienteDao();
    }
    @Test
    public void deveBuscarCliente() {
        Cliente c = service.buscarPorId(1);
        assertNotNull(c);
        assertEquals("João", c.getNome());

        Cliente c2 = service.buscarPorId(2);
        assertNotNull(c2);
        assertEquals("Maria", c2.getNome());
        // aqui ele esta assegurando que o 1 id o nome sera joão e o 2 Maria
    }

    @Test
    public void deveAtualizarCliente() {
        Cliente c = service.buscarPorId(1);
        // aqui ele atualiza o nome pegando o primeiro nome que era João e sobreescrevendo ele para
        // João Pinheiro.
        c.setNome("João Pinheiro");

        // ele vai buscar pelo id 1 setar o nome para João Pinheiro e testar.
        service.atualizar(c);
        assertEquals("João Pinheiro", service.buscarPorId(1).getNome());

        // aqui ele vai buscar pelo id 2 setar o nome para Maria Da Silva e ter Ctz disso.
        Cliente c2  = service.buscarPorId(2);
        c2.setNome("Maria Da Silva");
        service.atualizar(c2);
        assertEquals("Maria Da Silva", service.buscarPorId(2).getNome());
    }

    @Test
    public void deveExcluirCliente() {
        service.excluir(1);// aqui ele apaga o primeiro id
        assertNull(service.buscarPorId(1)); // e ele busca o primeiro id, como ele foi deletado
        // retornara um sucesso
        service.excluir(2);
        // o mesmo fara com o segundo id... meu querido.
        assertNull(service.buscarPorId(2));
    }

    @Test
    public void deveBuscarClienteDao() {
        Cliente c = clientedao.buscarPorId(1);
        assertNotNull(c);// o mesmo código de cima é o do dao, então nao há oque comentar.
        assertEquals("Ana", c.getNome());

        Cliente c2 = clientedao.buscarPorId(2);
        assertNotNull(c2);
        assertEquals("Carlos", c2.getNome());
    }

    @Test
    public void deveAtualizarClienteDao() {
        Cliente c = clientedao.buscarPorId(1);
        c.setNome("Ana Maria");
        clientedao.atualizar(c);
        assertEquals("Ana Maria", clientedao.buscarPorId(1).getNome());

        Cliente c2 = clientedao.buscarPorId(2);
        c2.setNome("Carlos Mathias");
        clientedao.atualizar(c2);
        assertEquals("Carlos Mathias", clientedao.buscarPorId(2).getNome());
    }

    @Test
    public void deveExcluirClienteDao() {
        clientedao.excluir(1);
        assertNull(clientedao.buscarPorId(1));
        clientedao.excluir(2);
        assertNull(clientedao.buscarPorId(2));
    }
}

