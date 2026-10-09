package com.marcasluxo.infrastructure.entitys;

import jakarta.persistence.*;

@Table(name = "marcas")
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "ano_fundacao")
    private Integer anoFundacao;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "faturamento_bilhoes")
    private Double faturamentoBilhoes;

    @Column(name = "descricao", length = 1000)
    private String descricao;

    @Column(name = "site_oficial")
    private String siteOficial;

    // Construtor padrão exigido pelo JPA
    public Marca() {
    }

    // Construtor completo
    public Marca(Long id, String nome, String paisOrigem, Integer anoFundacao, String categoria, Double faturamentoBilhoes, String descricao, String siteOficial) {
        this.id = id;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoFundacao = anoFundacao;
        this.categoria = categoria;
        this.faturamentoBilhoes = faturamentoBilhoes;
        this.descricao = descricao;
        this.siteOficial = siteOficial;
    }

    // Getters e Setters
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

    public Double getFaturamentoBilhoes() {
        return faturamentoBilhoes;
    }

    public void setFaturamentoBilhoes(Double faturamentoBilhoes) {
        this.faturamentoBilhoes = faturamentoBilhoes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSiteOficial() {
        return siteOficial;
    }

    public void setSiteOficial(String siteOficial) {
        this.siteOficial = siteOficial;
    }

    // Padrão Builder nativo (sem depender do Lombok)
    public static MarcaBuilder builder() {
        return new MarcaBuilder();
    }

    public static class MarcaBuilder {
        private Long id;
        private String nome;
        private String paisOrigem;
        private Integer anoFundacao;
        private String categoria;
        private Double faturamentoBilhoes;
        private String descricao;
        private String siteOficial;

        public MarcaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public MarcaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public MarcaBuilder paisOrigem(String paisOrigem) {
            this.paisOrigem = paisOrigem;
            return this;
        }

        public MarcaBuilder anoFundacao(Integer anoFundacao) {
            this.anoFundacao = anoFundacao;
            return this;
        }

        public MarcaBuilder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public MarcaBuilder faturamentoBilhoes(Double faturamentoBilhoes) {
            this.faturamentoBilhoes = faturamentoBilhoes;
            return this;
        }

        public MarcaBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public MarcaBuilder siteOficial(String siteOficial) {
            this.siteOficial = siteOficial;
            return this;
        }

        public Marca build() {
            return new Marca(id, nome, paisOrigem, anoFundacao, categoria, faturamentoBilhoes, descricao, siteOficial);
        }
    }
}
