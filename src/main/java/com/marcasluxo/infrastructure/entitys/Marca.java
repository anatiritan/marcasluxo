package com.marcasluxo.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}
