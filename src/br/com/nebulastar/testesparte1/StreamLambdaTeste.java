package br.com.nebulastar.testesparte1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nebula Stardust
 */
public class StreamLambdaTeste {

    public static List<String> filtrarMulheres(List<String> pessoas) {

        // não é possivel utilizar o scanner para testes unitarios
        // então tudo é feito com código fechado..
        // arreios e tudo mais..
        // é um quebra cabeça legalzinho
        List<String> mulheres = new ArrayList<>();

        pessoas.forEach(pessoa -> {
            // o virgula faz ele separar o primeiro do segundo arreio.
            // então Ana vira nome e o F vira sexo.
            // poderia ser Ana,19 ai seria String nome e Integer idade.
            String[] dados = pessoa.split(",");
            String nome = dados[0];
            String sexo = dados[1];
            // se no sexo houver F ele vai adicionar nas mulheres, simples assim.
            if (sexo.equalsIgnoreCase("F")) {
                mulheres.add(nome);
            }
        });
        // aqui ele fecha a lista retornando as mulheres na lista
        return mulheres;
    }
}