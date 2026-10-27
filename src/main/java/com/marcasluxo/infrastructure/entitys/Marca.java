package com.marcasluxo.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "marca")
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_marca", length = 100, nullable = false)
    private String nomeMarca;

    @Column(name = "ano_fundacao")
    private Integer anoFundacao;

    @Column(name = "pais_origem", length = 100)
    private String paisOrigem;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "fundador", length = 100)
    private String fundador;
}
