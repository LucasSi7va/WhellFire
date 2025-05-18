package org.ProjetoBloco.bikes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;


@Entity
public class Bikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private String cor;
    private  String tipo;
    private  BigDecimal preco;


    public Bikes() {
    }


    public Bikes(String marca, String modelo, String cor, String tipo, BigDecimal preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
     this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
