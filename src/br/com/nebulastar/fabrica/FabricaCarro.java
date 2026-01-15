package br.com.nebulastar.fabrica;

import br.com.nebulastar.direcao.Direcao;
import br.com.nebulastar.direcao.DirecaoCarro;
import br.com.nebulastar.seguranca.Seguranca;
import br.com.nebulastar.seguranca.SegurancaCarro;

public class FabricaCarro implements FabricaVeiculo {

    // aqui ele vai atribuir a segurança como segurança carro
    public Seguranca getSeguranca() {
        return new SegurancaCarro();
    }
    // e aqui ele vai atribuir a direção como direção carro!
    public Direcao getDirecao() {
        return new DirecaoCarro();
    }

}
