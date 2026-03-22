package br.com.nebulastar.services;

import br.com.nebulastar.dao.IProdutoDAO;
import br.com.nebulastar.domain.Produto;
import br.com.nebulastar.services.generic.GenericService;

/**
 * Created by Nebula Stardust
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
