package br.com.nebulastar.direcao;

public class DirecaoMoto implements Direcao {
    // como a direção é algo de interface, aqui atribuo ele para moto!
    public void getDirecao() {
        System.out.println("Guidão");
    }

}
