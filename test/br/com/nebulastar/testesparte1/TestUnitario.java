package br.com.nebulastar.testesparte1;

import br.com.nebulastar.lambdahibrido.StreamLambdaTeste;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nebula Stardust
 */
public class TestUnitario {

    @Test
    public void somenteMulheres() {

        List<String> pessoas = Arrays.asList(
                "Ana,F",
                "Maria,F",
                "Joao,M",
                "Carlos,M",
                "Julia,F"
        );

        // chamando o filtro para deixar apenas as mulheres ( Ana, Maria, Julia )
        List<String> resultado = StreamLambdaTeste.filtrarMulheres(pessoas);

        // ele vai verificar se a ana maria e a julia estão presentes.
        // se elas não estiverem na lista o teste falha. se houver mais doque 3 também e se tiver menos. também.

        assertEquals(3, resultado.size());
        assertTrue(resultado.contains("Ana"));
        assertTrue(resultado.contains("Maria"));
        assertTrue(resultado.contains("Julia"));
    }
    @Test
    public void naoDeveConterHomens() {

        List<String> pessoas = Arrays.asList(
                "Ana,F",
                "Joao,M",
                "Maria,F"
        );

        //chamando o filtro pra ter certeza que só havera mulheres na lista
        List<String> resultado = StreamLambdaTeste.filtrarMulheres(pessoas);
        //Se joão aparecer na lista ele vai apitar como falso.
        assertFalse(resultado.contains("Joao"));
    }
}

