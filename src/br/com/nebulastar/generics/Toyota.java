package br.com.nebulastar.generics;

public class Toyota extends Carro{

    public Toyota(String modelo) {
        super(modelo);
    }
    @Override
    public void info() {
        System.out.println("O novo " + modelo + " é muito economico!");
    }
}
