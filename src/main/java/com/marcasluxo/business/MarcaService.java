package com.marcasluxo.business;

import com.marcasluxo.infrastructure.entitys.Marca;
import com.marcasluxo.infrastructure.repository.MarcaRepository;
import org.springframework.stereotype.Service;

// Camada de serviço contendo a lógica de negócio da aplicação
@Service
public class MarcaService {

    private final MarcaRepository repository;

    // Injeção de dependência do repositório via construtor
    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    // Salva ou atualiza a marca e descarrega as alterações no banco imediatamente
    public void salvarMarca(Marca marca) {
        repository.saveAndFlush(marca);
    }

    // Busca a marca pelo nome; lança exceção caso não encontre
    public Marca buscarMarcaPorNomeMarca(String nomeMarca) {
        return repository.findByNomeMarca(nomeMarca).orElseThrow(
                () -> new RuntimeException("Nome da marca não encontrado")
        );
    }

    // Remove a marca correspondente ao nome informado
    public void deletarMarcaPorNome(String nomeMarca) {
        repository.deleteByNomeMarca(nomeMarca);
    }

    // Atualiza apenas os campos enviados, preservando os dados existentes
    public void atualizarMarcaPorId(Integer id, Marca marca) {
        // Localiza a marca existente pelo id ou lança erro
        Marca marcaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Marca não encontrada"));

        // Monta o objeto atualizado usando o padrão Builder do Lombok
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

        // Salva as alterações no banco de dados
        repository.saveAndFlush(marcaAtualizada);
    }
}
