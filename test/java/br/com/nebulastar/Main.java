package br.com.nebulastar;

/**
 * Created by Nebula Stardust
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver encontrado!");
    }
}
