package br.com.nebulastar.fabrica;


import br.com.nebulastar.direcao.Direcao;
import br.com.nebulastar.seguranca.Seguranca;

public class Venda {

    private Seguranca seguranca;
    private Direcao direcao;

    public Venda(FabricaVeiculo fabrica){
        seguranca = fabrica.getSeguranca();
        direcao = fabrica.getDirecao();
    }

    public void vender(){
        seguranca.getSeguranca();
        direcao.getDirecao();
    }
}
