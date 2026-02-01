package br.com.nebulastar.annotation;

/**
 * Created by Nebula Stardust
 */
public class APP {

    @Annotation(nome={"Annotation METHOD"})
    static void main(String[] args) {
        new UsingAnnotation();
    }
}
