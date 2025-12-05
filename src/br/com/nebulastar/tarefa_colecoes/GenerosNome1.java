package br.com.nebulastar.tarefa_colecoes;

import java.util.*;

/**
 * @author Nebula Stardust
 */
public class GenerosNome1 {
    public static void main(String[] args) {
        System.out.println("Nomes e sexo separados por , :");
        Scanner s = new Scanner(System.in);
        String answer = s.next();
        String[] nomes = answer.split(",");
        List<String> pessoas = Arrays.asList(nomes);
        List<String> seres = new LinkedList<>(pessoas);
        int aux = 0;
        int n = 0;

        System.out.println("");
        pessoas.sort(Comparator.naturalOrder());
        pessoas.replaceAll(string -> string.replace("-m", ""));
        pessoas.replaceAll(string -> string.replace("-f", ""));
        System.out.println("Nomes sem separação por gênero mas organizado: ");
        System.out.println(pessoas);
        System.out.println("");
    }
}
