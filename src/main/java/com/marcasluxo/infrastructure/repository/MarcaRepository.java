package com.marcasluxo.infrastructure.repository;

import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByNome(String nome);

    List<Marca> findByCategoriaIgnoreCase(String categoria);

    List<Marca> findByPaisOrigemIgnoreCase(String paisOrigem);

    boolean existsByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
