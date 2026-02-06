package br.com.nebulastar.reflections;

/**
 * Created by Nebula Stardust
 */
@FirstAnno(value = "ClassWithAnno")
public class ClassWithAnno {


    @FirstAnno(value = "NomeDoCampo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}