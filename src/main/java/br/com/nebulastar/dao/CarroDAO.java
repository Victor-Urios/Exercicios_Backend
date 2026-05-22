package br.com.nebulastar.dao;

import br.com.nebulastar.domain.Carro;

/**
 * Created by Nebula Stardust
 */
public class CarroDAO extends GenericDAO<Carro> {
    public CarroDAO() {
        super(Carro.class);
    }
}