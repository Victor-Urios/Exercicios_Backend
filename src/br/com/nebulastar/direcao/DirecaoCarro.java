package br.com.nebulastar.direcao;

public class DirecaoCarro implements Direcao {
    // como a direção é algo de interface, aqui atribuo ele para carro!
    public void getDirecao() {
        System.out.println("Volante emborrachado");
    }

}
