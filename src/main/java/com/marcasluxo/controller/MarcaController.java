package com.marcasluxo.controller;

import com.marcasluxo.business.MarcaService;
import com.marcasluxo.infrastructure.entitys.Marca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controlador REST que expõe os endpoints HTTP na rota base /marca
@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor // Lombok gera o construtor automaticamente com as dependências 'final'
public class MarcaController {

    private final MarcaService marcaService;

    // Endpoint POST: cadastra uma nova marca recebendo os dados via corpo da requisição (JSON)
    @PostMapping
    public ResponseEntity<Void> salvarMarca(@RequestBody Marca marca) {
        marcaService.salvarMarca(marca);
        return ResponseEntity.ok().build();
    }

    // Endpoint GET: busca uma marca pelo nome recebido como parâmetro de consulta (?nome=...)
    @GetMapping
    public ResponseEntity<Marca> buscarMarcaPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(marcaService.buscarMarcaPorNomeMarca(nome));
    }

    // Endpoint DELETE: deleta uma marca pelo nome informado como parâmetro (?nome=...)
    @DeleteMapping
    public ResponseEntity<Void> deletarMarcaPorNome(@RequestParam String nome) {
        marcaService.deletarMarcaPorNome(nome);
        return ResponseEntity.ok().build();
    }

    // Endpoint PUT: atualiza a marca pelo ID (?id=...) com os dados enviados no JSON
    @PutMapping
    public ResponseEntity<Void> atualizarMarcaPorId(@RequestBody Marca marca, @RequestParam Integer id) {
        marcaService.atualizarMarcaPorId(id, marca);
        return ResponseEntity.ok().build();
    }
}
