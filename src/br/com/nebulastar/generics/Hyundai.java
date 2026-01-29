package br.com.nebulastar.generics;

public class Hyundai extends Carro{

    public Hyundai(String modelo) {
        super(modelo);
    }

    @Override
    public void info() {
        System.out.println("O novo " + modelo + " é uma atração para aplicativo de transporte!");
    }
}
