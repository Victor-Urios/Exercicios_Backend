package br.com.nebulastar.generics;

public abstract class Carro {
    protected String modelo;

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public abstract void info();

    public String getModelo() {
        return modelo;
    }
}