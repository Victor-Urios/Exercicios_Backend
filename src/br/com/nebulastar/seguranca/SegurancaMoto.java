package br.com.nebulastar.seguranca;

public class SegurancaMoto implements Seguranca {
    // como a segurança é algo de interface, aqui atribuo ele para moto!
    public void getSeguranca() {
        System.out.println("Capacete e jaqueta de motoboy");
    }

}
