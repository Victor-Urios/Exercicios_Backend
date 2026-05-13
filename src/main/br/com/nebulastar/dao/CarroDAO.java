package main.br.com.nebulastar.dao;

import main.br.com.nebulastar.domain.Carro;

/**
 * Created by Nebula Stardust
 */
public class CarroDAO extends GenericDAO<Carro> {
    public CarroDAO() {
        super(Carro.class);
    }
}