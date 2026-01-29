package br.com.nebulastar.generics;
import java.util.ArrayList;
import java.util.List;

public class Vitrine<T extends Carro> {

    private List<T> carros = new ArrayList<>();

    public void adicionarCarro(T carro) {
        carros.add(carro);
    }

    public void listarCarros() {
        for (T carro : carros) {
            System.out.println("Modelo: " + carro.getModelo());
            carro.info();
        }
    }
}
