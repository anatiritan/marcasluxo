package com.marcasluxo.infrastructure.repository;

import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// Interface de repositório herdando os métodos CRUD prontos do JpaRepository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    // Busca uma marca pelo nome utilizando a convenção de busca do Spring Data JPA
    Optional<Marca> findByNomeMarca(String nomeMarca);

    // Deleta uma marca pelo nome; @Transactional garante o controle da transação no banco
    @Transactional
    void deleteByNomeMarca(String nomeMarca);
}
