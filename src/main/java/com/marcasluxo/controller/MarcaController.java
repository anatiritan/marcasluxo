package com.marcasluxo.controller;

import com.marcasluxo.business.MarcaService;
import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "*") // Permite requisições de front-end ou ferramentas externas
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    // CREATE - Salvar nova marca
    @PostMapping
    public ResponseEntity<Marca> salvarMarca(@RequestBody Marca marca) {
        Marca novaMarca = marcaService.salvarMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca);
    }

    // READ - Buscar todas as marcas
    @GetMapping
    public ResponseEntity<List<Marca>> buscarTodasMarcas() {
        List<Marca> marcas = marcaService.buscarTodasMarcas();
        return ResponseEntity.ok(marcas);
    }

    // READ - Buscar marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarMarcaPorId(@PathVariable Long id) {
        Marca marca = marcaService.buscarMarcaPorId(id);
        return ResponseEntity.ok(marca);
    }

    // READ - Buscar marca por Nome (ex: /marcas/busca?nome=Chanel)
    @GetMapping("/busca")
    public ResponseEntity<Marca> buscarMarcaPorNome(@RequestParam("nome") String nome) {
        Marca marca = marcaService.buscarMarcaPorNome(nome);
        return ResponseEntity.ok(marca);
    }

    // READ - Buscar marcas por Categoria (ex: /marcas/categoria/Alta Costura)
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Marca>> buscarMarcasPorCategoria(@PathVariable String categoria) {
        List<Marca> marcas = marcaService.buscarMarcasPorCategoria(categoria);
        return ResponseEntity.ok(marcas);
    }

    // READ - Buscar marcas por País de Origem (ex: /marcas/pais/França)
    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Marca>> buscarMarcasPorPais(@PathVariable String pais) {
        List<Marca> marcas = marcaService.buscarMarcasPorPais(pais);
        return ResponseEntity.ok(marcas);
    }

    // UPDATE - Atualizar marca existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @RequestBody Marca marca) {
        Marca marcaAtualizada = marcaService.atualizarMarca(id, marca);
        return ResponseEntity.ok(marcaAtualizada);
    }

    // UPDATE - Atualizar marca existente por Nome (ex: PUT /marcas?nome=Gucci)
    @PutMapping
    public ResponseEntity<Marca> atualizarMarcaPorNome(@RequestParam("nome") String nome, @RequestBody Marca marca) {
        Marca marcaAtualizada = marcaService.atualizarMarcaPorNome(nome, marca);
        return ResponseEntity.ok(marcaAtualizada);
    }

    // DELETE - Deletar marca por ID (ex: DELETE /marcas/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarcaPorId(@PathVariable Long id) {
        marcaService.deletarMarcaPorId(id);
        return ResponseEntity.noContent().build();
    }

    // DELETE - Deletar marca por Nome (ex: DELETE /marcas?nome=Chanel)
    @DeleteMapping
    public ResponseEntity<Void> deletarMarcaPorNome(@RequestParam("nome") String nome) {
        marcaService.deletarMarcaPorNome(nome);
        return ResponseEntity.noContent().build();
    }
}
