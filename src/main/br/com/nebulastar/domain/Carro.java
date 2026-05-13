package main.br.com.nebulastar.domain;

import javax.persistence.*;

/**
 * Created by Nebula Stardust
 */
@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_MARCA", nullable = false)
    private Marca marca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_ACESSORIOS", nullable = false)
    private Acessorios acessorios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Acessorios getAcessorio() {
        return acessorios;
    }

    public void setAcessorio(Acessorios acessorios) {
        this.acessorios = acessorios;
    }
}