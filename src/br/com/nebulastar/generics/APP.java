package br.com.nebulastar.generics;

public class APP {

    static void main(String[] args) {

        Vitrine<Carro> vitrine = new Vitrine<>();

        vitrine.adicionarCarro(new Honda("Civic"));
        vitrine.adicionarCarro(new Hyundai("HB20"));
        vitrine.adicionarCarro(new Toyota("Hilux"));

        vitrine.listarCarros();
    }
}
