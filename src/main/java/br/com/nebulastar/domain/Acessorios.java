package main.java.br.com.nebulastar.domain;

import javax.persistence.*;

/**
 * Created by Nebula Stardust
 */
@Entity
@Table(name = "TB_ACESSORIOS")
@SequenceGenerator(
        name = "acess_seq",
        sequenceName = "sq_acess",
        initialValue = 1,
        allocationSize = 1
)
public class Acessorios {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acess_seq")
    private Long id;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
