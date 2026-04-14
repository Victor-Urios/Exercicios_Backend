package br.com.nebulastar.domain;

import java.math.BigDecimal;

/**
 * Created by Nebula Stardust
 */
public class Produto {

    private String nome;

    private Integer codigo;

    private BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
