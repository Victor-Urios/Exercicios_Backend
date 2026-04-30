package main.java.br.com.nebulastar.domain;

import javax.persistence.*;

/**
 * Created by Nebula Stardust
 */
@Entity
@Table(name = "TB_MARCA")
@SequenceGenerator(
        name = "marca_seq",
        sequenceName = "sq_marca",
        initialValue = 1,
        allocationSize = 1
)
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
