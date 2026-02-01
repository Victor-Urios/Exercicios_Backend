package br.com.nebulastar.annotation;

/**
 * Created by Nebula Stardust
 */

//Usando em TYPE
@Annotation(nome = {"Annotation TYPE"})
public class UsingAnnotation {

    //Usando em FIELD
    @Annotation(nome = {"Annotation FIELD"})
    private String nome;

    @Annotation(nome ={"Annotation CONSTRUCTOR"})
    public UsingAnnotation(){
            System.out.println("Do 0 ao 5!");
        for(int i = 0; i <=5; i++) {
            System.out.println(i);
        }

    }
}
