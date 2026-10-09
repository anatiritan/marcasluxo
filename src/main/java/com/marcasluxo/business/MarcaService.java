package com.marcasluxo.business;

import com.marcasluxo.infrastructure.entitys.Marca;
import com.marcasluxo.infrastructure.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service avisa ao Spring Boot que esta classe contem a logica de negocio da aplicacao
@Service
public class MarcaService {

    // Declaramos o repositorio que conversa com o banco de dados
    private final MarcaRepository marcaRepository;

    // Construtor para injeção de dependência: o proprio Spring Boot instancia e entrega o repositorio aqui
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    // Metodo 1: CREATE / UPDATE - Salva uma nova marca no banco de dados
    public Marca salvarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    // Metodo 2: READ - Retorna a lista com todas as marcas cadastradas
    public List<Marca> listarTodasMarcas() {
        return marcaRepository.findAll();
    }

    // Metodo 3: READ - Busca uma marca especifica pelo seu ID
    public Marca buscarMarcaPorId(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    // Metodo 4: DELETE - Remove uma marca do banco pelo ID
    public void deletarMarcaPorId(Long id) {
        marcaRepository.deleteById(id);
    }
}
