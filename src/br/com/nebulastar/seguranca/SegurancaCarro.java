package br.com.nebulastar.seguranca;

public class SegurancaCarro implements Seguranca {
    // como a segurança é algo de interface, aqui atribuo ele para carro!
    public void getSeguranca() {
        System.out.println("Cinto de segurança");
    }

}
