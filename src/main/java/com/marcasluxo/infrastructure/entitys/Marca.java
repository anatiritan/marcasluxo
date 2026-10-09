package com.marcasluxo.infrastructure.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity avisa ao Spring Boot que esta classe representa uma tabela no banco de dados
@Entity
// @Table define o nome da tabela que sera criada dentro do banco H2
@Table(name = "marcas")
public class Marca {

    // @Id indica que este atributo eh a chave primaria (identificador unico) da tabela
    // @GeneratedValue com GenerationType.IDENTITY faz o banco gerar os IDs automaticamente (1, 2, 3...)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos basicos do nosso tema de marcas de luxo
    private String nome;
    private String paisOrigem;
    private Integer anoFundacao;
    private String categoria;

    // Construtor padrao vazio (obrigatorio para o JPA conseguir instanciar a classe)
    public Marca() {
    }

    // Construtor com parametros (para facilitar quando quisermos criar uma marca com os dados preenchidos)
    public Marca(Long id, String nome, String paisOrigem, Integer anoFundacao, String categoria) {
        this.id = id;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoFundacao = anoFundacao;
        this.categoria = categoria;
    }

    // --- GETTERS E SETTERS ---
    // Servem para permitir o acesso e modificacao segura dos atributos privados (Encapsulamento de POO)

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

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Integer getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(Integer anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
