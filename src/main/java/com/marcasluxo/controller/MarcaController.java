package com.marcasluxo.controller;

import com.marcasluxo.business.MarcaService;
import com.marcasluxo.infrastructure.entitys.Marca;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController define que esta classe eh um controlador REST (recebe chamadas HTTP e devolve dados em JSON)
@RestController
// @RequestMapping define o caminho base da rota na web: http://localhost:8080/marcas
@RequestMapping("/marcas")
public class MarcaController {

    // Chamamos a camada de servico (Service) para executar as acoes
    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    // 1. CREATE - Endpoint para cadastrar uma nova marca
    // Exemplo de requisicao: POST http://localhost:8080/marcas com JSON no corpo
    // @RequestBody converte o JSON enviado pelo usuario em um objeto Java Marca
    @PostMapping
    public Marca salvarMarca(@RequestBody Marca marca) {
        return marcaService.salvarMarca(marca);
    }

    // 2. READ - Endpoint para listar todas as marcas cadastradas
    // Exemplo de requisicao: GET http://localhost:8080/marcas
    @GetMapping
    public List<Marca> listarTodasMarcas() {
        return marcaService.listarTodasMarcas();
    }

    // 3. READ - Endpoint para buscar uma marca especifica pelo seu ID
    // Exemplo de requisicao: GET http://localhost:8080/marcas/1
    // @PathVariable pega o numero '1' que veio na URL e passa para a variavel 'id'
    @GetMapping("/{id}")
    public Marca buscarMarcaPorId(@PathVariable Long id) {
        return marcaService.buscarMarcaPorId(id);
    }

    // 4. DELETE - Endpoint para deletar uma marca pelo seu ID
    // Exemplo de requisicao: DELETE http://localhost:8080/marcas/1
    @DeleteMapping("/{id}")
    public void deletarMarcaPorId(@PathVariable Long id) {
        marcaService.deletarMarcaPorId(id);
    }
}
