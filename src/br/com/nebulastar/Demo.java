package br.com.nebulastar;

// manterei o fabrica veiculo nas importações mesmo sabendo que ele não vai usar.
import br.com.nebulastar.fabrica.FabricaVeiculo;
import br.com.nebulastar.fabrica.Venda;
import br.com.nebulastar.fabrica.FabricaCarro;
import br.com.nebulastar.fabrica.FabricaMoto;

public class Demo {

    //public static void main(String[] args) NÃO PRECISA MAIS DO PUBLIC.
    static void main(String[] args){

        //aqui ele vai pegar os componentes da fabrica moto e montar!
        System.out.println("Foi Vendido uma moto");
//       Venda vendaUm = new Venda((FabricaVeiculo) new FabricaMoto()); diz que é redundante a forma feita então.
//       Deixárei comentado.

        Venda vendaUm = new Venda(new FabricaMoto());
        vendaUm.vender();

        //aqui ele vai pegar os componentes da fábrica carro e montar!
        System.out.println("Foi Vendido um Carro");
        Venda vendaDois = new Venda(new FabricaCarro());
        vendaDois.vender();

    }

}
