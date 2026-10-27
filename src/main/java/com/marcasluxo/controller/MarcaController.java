package com.marcasluxo.controller;

import com.marcasluxo.business.MarcaService;
import com.marcasluxo.infrastructure.entitys.Marca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @PostMapping
    public ResponseEntity<Void> salvarMarca(@RequestBody Marca marca) {
        marcaService.salvarMarca(marca);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Marca> buscarMarcaPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(marcaService.buscarMarcaPorNomeMarca(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarMarcaPorNome(@RequestParam String nome) {
        marcaService.deletarMarcaPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarMarcaPorId(@RequestBody Marca marca, @RequestParam Integer id) {
        marcaService.atualizarMarcaPorId(id, marca);
        return ResponseEntity.ok().build();
    }
}
