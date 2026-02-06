package br.com.nebulastar.reflections;

/**
 * Created by Nebula Stardust
 */

import java.lang.reflect.Field;

public class AnnoReader {

    public static void main(String[] args) {

        // aqui ele vai puxar tudo do arquivo FirstAnno.java e como ele já é convertido para classe...
        Class<?> classe = ClassWithAnno.class;


        if (classe.isAnnotationPresent(FirstAnno.class)) {

            // declarando a primeira anotação
            FirstAnno annoClass = classe.getAnnotation(FirstAnno.class);

            //colocando ela como string
            String tabela = annoClass.value();

            // lendo o nome da tabela caso ele exista
            System.out.println(" Nome da Tabela lido da Anotação da Classe: " + tabela);
        } else {// se ele não existir, essa mensagem será colocada no lugar
            System.out.println(" A classe não possui a anotação @PrimeiraAnotacao.");
        }

        System.out.println("********************************");


        try {
            Field campoNome = classe.getDeclaredField("nome");
            if (campoNome.isAnnotationPresent(FirstAnno.class)) {
                FirstAnno annoCamp = campoNome.getAnnotation(FirstAnno.class);
                String campValue = annoCamp.value();
                System.out.println(" Valor da Anotação do Campo 'nome': " + campValue);
            }
        } catch (NoSuchFieldException e) {
            System.out.println("Campo 'nome' não encontrado.");
        }
    }
}
