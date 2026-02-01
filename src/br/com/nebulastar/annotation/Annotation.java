package br.com.nebulastar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Nebula Stardust
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface Annotation {

    //algo simples criando o nome da annotation
    String[] nome();
}
