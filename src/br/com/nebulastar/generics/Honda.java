package br.com.nebulastar.generics;

public class Honda extends Carro{

    public Honda(String modelo) {
        super(modelo);
    }
    @Override
    public void info() {
        System.out.println("O novo " + modelo + " é muito economico!");
    }

}
