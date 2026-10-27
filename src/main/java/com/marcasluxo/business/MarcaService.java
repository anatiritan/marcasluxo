package com.marcasluxo.business;

import com.marcasluxo.infrastructure.entitys.Marca;
import com.marcasluxo.infrastructure.repository.MarcaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public void salvarMarca(Marca marca) {
        repository.saveAndFlush(marca);
    }

    public Marca buscarMarcaPorNomeMarca(String nomeMarca) {
        return repository.findByNomeMarca(nomeMarca).orElseThrow(
                () -> new RuntimeException("Nome da marca não encontrado")
        );
    }

    public void deletarMarcaPorNome(String nomeMarca) {
        repository.deleteByNomeMarca(nomeMarca);
    }

    public void atualizarMarcaPorId(Integer id, Marca marca) {
        Marca marcaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Marca não encontrada"));

        Marca marcaAtualizada = Marca.builder()
                .nomeMarca(marca.getNomeMarca() != null ? marca.getNomeMarca() :
                        marcaEntity.getNomeMarca())
                .anoFundacao(marca.getAnoFundacao() != null ? marca.getAnoFundacao() :
                        marcaEntity.getAnoFundacao())
                .paisOrigem(marca.getPaisOrigem() != null ? marca.getPaisOrigem() :
                        marcaEntity.getPaisOrigem())
                .categoria(marca.getCategoria() != null ? marca.getCategoria() :
                        marcaEntity.getCategoria())
                .fundador(marca.getFundador() != null ? marca.getFundador() :
                        marcaEntity.getFundador())
                .id(marcaEntity.getId())
                .build();

        repository.saveAndFlush(marcaAtualizada);
    }
}
