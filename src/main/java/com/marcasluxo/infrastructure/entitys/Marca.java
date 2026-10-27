package com.marcasluxo.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

// Anotações do Lombok para gerar getters, setters, construtores e o padrão builder automaticamente
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Define que esta classe é uma entidade gerenciada pelo JPA mapeada para a tabela "marca"
@Table(name = "marca")
@Entity
public class Marca {

    // Chave primária autoincrementada pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Coluna do nome da marca, obrigatória (não nula) e com até 100 caracteres
    @Column(name = "nome_marca", length = 100, nullable = false)
    private String nomeMarca;

    // Coluna do ano de fundação da marca
    @Column(name = "ano_fundacao")
    private Integer anoFundacao;

    // Coluna do país de origem da marca
    @Column(name = "pais_origem", length = 100)
    private String paisOrigem;

    // Coluna da categoria/segmento (ex: Alta Costura, Relojoaria)
    @Column(name = "categoria", length = 50)
    private String categoria;

    // Coluna do(a) fundador(a) histórico(a) da grife
    @Column(name = "fundador", length = 100)
    private String fundador;
}
