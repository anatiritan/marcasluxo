package com.marcasluxo.business;

import com.marcasluxo.infrastructure.entitys.Marca;
import com.marcasluxo.infrastructure.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca salvarMarca(Marca marca) {
        if (marca.getId() == null && marcaRepository.existsByNome(marca.getNome())) {
            throw new RuntimeException("Já existe uma marca cadastrada com o nome: " + marca.getNome());
        }
        return marcaRepository.save(marca);
    }

    public List<Marca> buscarTodasMarcas() {
        return marcaRepository.findAll();
    }

    public Marca buscarMarcaPorId(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o ID: " + id));
    }

    public Marca buscarMarcaPorNome(String nome) {
        return marcaRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com o nome: " + nome));
    }

    public List<Marca> buscarMarcasPorCategoria(String categoria) {
        return marcaRepository.findByCategoriaIgnoreCase(categoria);
    }

    public List<Marca> buscarMarcasPorPais(String pais) {
        return marcaRepository.findByPaisOrigemIgnoreCase(pais);
    }

    public Marca atualizarMarca(Long id, Marca dadosAtualizados) {
        Marca marcaExistente = buscarMarcaPorId(id);

        marcaExistente.setNome(dadosAtualizados.getNome());
        marcaExistente.setPaisOrigem(dadosAtualizados.getPaisOrigem());
        marcaExistente.setAnoFundacao(dadosAtualizados.getAnoFundacao());
        marcaExistente.setCategoria(dadosAtualizados.getCategoria());
        marcaExistente.setFaturamentoBilhoes(dadosAtualizados.getFaturamentoBilhoes());
        marcaExistente.setDescricao(dadosAtualizados.getDescricao());
        marcaExistente.setSiteOficial(dadosAtualizados.getSiteOficial());

        return marcaRepository.save(marcaExistente);
    }

    public Marca atualizarMarcaPorNome(String nome, Marca dadosAtualizados) {
        Marca marcaExistente = buscarMarcaPorNome(nome);

        if (dadosAtualizados.getNome() != null) {
            marcaExistente.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getPaisOrigem() != null) {
            marcaExistente.setPaisOrigem(dadosAtualizados.getPaisOrigem());
        }
        if (dadosAtualizados.getAnoFundacao() != null) {
            marcaExistente.setAnoFundacao(dadosAtualizados.getAnoFundacao());
        }
        if (dadosAtualizados.getCategoria() != null) {
            marcaExistente.setCategoria(dadosAtualizados.getCategoria());
        }
        if (dadosAtualizados.getFaturamentoBilhoes() != null) {
            marcaExistente.setFaturamentoBilhoes(dadosAtualizados.getFaturamentoBilhoes());
        }
        if (dadosAtualizados.getDescricao() != null) {
            marcaExistente.setDescricao(dadosAtualizados.getDescricao());
        }
        if (dadosAtualizados.getSiteOficial() != null) {
            marcaExistente.setSiteOficial(dadosAtualizados.getSiteOficial());
        }

        return marcaRepository.save(marcaExistente);
    }

    public void deletarMarcaPorId(Long id) {
        if (!marcaRepository.existsById(id)) {
            throw new RuntimeException("Não foi possível excluir: Marca não encontrada com o ID: " + id);
        }
        marcaRepository.deleteById(id);
    }

    public void deletarMarcaPorNome(String nome) {
        if (!marcaRepository.existsByNome(nome)) {
            throw new RuntimeException("Não foi possível excluir: Marca não encontrada com o nome: " + nome);
        }
        marcaRepository.deleteByNome(nome);
    }
}
