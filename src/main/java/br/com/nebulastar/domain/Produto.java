package main.java.br.com.nebulastar.domain;

import javax.persistence.*;

/**
 * Created by Nebula Stardust
 */
@Entity
@Table(name = "TB_PRODUTO2")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto2_seq")//  allocation size vai determinar o quanto q ele pula
    @SequenceGenerator(name="produto2_seq", sequenceName = "sq_produto2", initialValue = 1, allocationSize = 1)// por ex se fosse 10, ele começaria com 11, 21, 31
    private Long id;

    @Column(name = "CODIGO",length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME",length = 50, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO",length = 100, nullable = false)
    private String descricao;

    @Column(name="VALOR", nullable = false)
    private Double valor;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
