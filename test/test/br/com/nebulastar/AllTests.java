package test.br.com.nebulastar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Nebula Stardust
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
        ProdutoServiceTest.class, ProdutoDAOTest.class,
        VendaDAOTest.class})
public class AllTests {
}
