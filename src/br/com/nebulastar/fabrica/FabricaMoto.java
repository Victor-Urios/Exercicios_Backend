package br.com.nebulastar.fabrica;

import br.com.nebulastar.direcao.Direcao;
import br.com.nebulastar.direcao.DirecaoMoto;
import br.com.nebulastar.seguranca.Seguranca;
import br.com.nebulastar.seguranca.SegurancaMoto;

public class FabricaMoto implements FabricaVeiculo {

    public Seguranca getSeguranca() {
        return new SegurancaMoto();
    }

    public Direcao getDirecao() {
        return new DirecaoMoto();
    }

}
