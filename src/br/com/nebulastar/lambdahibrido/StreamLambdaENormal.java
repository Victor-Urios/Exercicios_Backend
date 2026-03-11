package br.com.nebulastar.lambdahibrido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nebula Stardust
 */
public class StreamLambdaENormal {

    // tarefa refeita usando em base a collections

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            List<String> pessoas = new ArrayList<>();
            List<String> mulheres = new ArrayList<>();

            // aqui é colocado quantas pessoas vão ser cadastrados
            System.out.println("Quantas pessoas deseja cadastrar?");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            // aqui um pequeno for, pra colocar quantas pessoas irão receber
            for (int i = 0; i < quantidade; i++) {
                System.out.println("Digite no formato nome,sexo (ex: Ana,F): ");
                String entrada = scanner.nextLine();
                pessoas.add(entrada);
            }

            // Aqui vai o uso do lambda :
            pessoas.forEach(pessoa -> {

                String[] dados = pessoa.split(",");
                String nome = dados[0];
                String sexo = dados[1];

                if (sexo.equalsIgnoreCase("F")) {
                    mulheres.add(nome);
                } else {
                    // homens são ignorados
                }

            });

            // Exibindo as mulheres.
            System.out.println("\nLista de Mulheres:");

            mulheres.forEach(System.out::println);

            scanner.close();
        }
    }
