package com.marcasluxo.infrastructure.repository;

import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository indica ao Spring que esta interface eh a camada de acesso ao banco de dados
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    // O JpaRepository<Marca, Long> ja traz pronto todos os metodos principais de banco:
    // - save() -> para salvar e atualizar registros
    // - findAll() -> para buscar todos os registros
    // - findById() -> para buscar um registro pelo ID
    // - deleteById() -> para excluir um registro pelo ID
    // Tudo isso sem a gente precisar escrever nenhum comando SQL manualmente!
}
