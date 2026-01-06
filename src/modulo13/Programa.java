package br.com.nebulastar.modulo13;

/**
 * @author Nebula Stardust
 */
public class Programa {
    public static void main(String[] args) {
            Fisica pessoa1 = new Fisica();
            pessoa1.setNome("Nebula");
            pessoa1.setSobrenome("Stardust");
            pessoa1.setCPF("123.456.789-10");
            System.out.println("Olá! " + pessoa1.getNome() +  " " + pessoa1.getSobrenome() + " Seu Cpf é : " + pessoa1.getCPF() + " Você é uma pessoa Fisica!");

            Juridica pessoa2 = new Juridica();
            pessoa2.setNome("Jordan");
            pessoa2.setSobrenome("Jorlan");
            pessoa2.setCPNJ("12.234.567/8910-11");
            System.out.println("Olá! " + pessoa2.getNome() + " " + pessoa2.getSobrenome() + " Seu CPNJ é : " + pessoa2.getCPNJ() + " Você é uma pessoa Juridica!");

    }
}
