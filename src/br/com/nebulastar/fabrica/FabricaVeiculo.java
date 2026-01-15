package br.com.nebulastar.fabrica;

import br.com.nebulastar.direcao.Direcao;
import br.com.nebulastar.seguranca.Seguranca;


// Aqui ele vai pegar se o veiculo é carro ou moto e fazer o veiculo.
public interface FabricaVeiculo {

    Seguranca getSeguranca();
    Direcao getDirecao();

}
