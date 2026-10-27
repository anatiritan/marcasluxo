package com.marcasluxo.infrastructure.repository;

import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    Optional<Marca> findByNomeMarca(String nomeMarca);

    @Transactional
    void deleteByNomeMarca(String nomeMarca);
}
