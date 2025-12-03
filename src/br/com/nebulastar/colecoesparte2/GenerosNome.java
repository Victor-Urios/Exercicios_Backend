package br.com.nebulastar.colecoesparte2;
import java.util.*;


/**
 * @author Nebula Stardust
 * como foi algo rapido é esperado colocar algo como André-m,Fabiana-f,Juliana-f,Pedro-m
 */
public class GenerosNome {

    public static void main(String[] args) {
        System.out.println("Nomes e sexo separados por , :");
        Scanner s = new Scanner(System.in);
        String answer = s.next();
        String[] nomes = answer.split(",");
        List<String> pessoas = Arrays.asList(nomes);
        List <String> seres = new LinkedList<>(pessoas);
        int aux = 0;
        int n = 0;

        System.out.println("");
        System.out.println("Nomes sem separação por gênero: ");
        System.out.println(pessoas);
        System.out.println("");

        System.out.println("*** Nomes masculinos *** ");
        System.out.println("Primeiro adicionado: ");
        List<String> generoMasculino = new ArrayList<String>();
        for (String homens : seres) {
            if (homens.contains("-m")) {
                homens = homens.replace("-m", "");
                generoMasculino.add(homens);
                System.out.println(generoMasculino);
            }
        }


        System.out.println("");

        System.out.println("*** Nomes femininos *** ");
        System.out.println("Primeira adicionada: ");
        List<String> generoFeminino = new ArrayList<String>();
        for (String mulheres : seres) {
            if (mulheres.contains("-f")) {
                mulheres = mulheres.replace("-f", "");
                generoFeminino.add(mulheres);
                System.out.println(generoFeminino);
            }
        }
    }
}

