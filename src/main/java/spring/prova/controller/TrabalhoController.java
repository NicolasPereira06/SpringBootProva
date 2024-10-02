package spring.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring.prova.entity.Trabalho;
import spring.prova.service.TrabalhoService;

import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    // Rota para cadastro de um novo trabalho (agora em /trabalho/cadastrar)
    @PostMapping("/cadastrar")
    public Trabalho cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        return trabalhoService.cadastrarTrabalho(trabalho);
    }

    // Rota para listar todos os trabalhos
    @GetMapping("/listar")
    public List<Trabalho> listarTodos() {
        return trabalhoService.listarTodos();
    }

    // Rota para buscar trabalhos por título e nota
    @GetMapping("/buscar")
    public List<Trabalho> buscarPorTituloENota(
        @RequestParam String palavra,
        @RequestParam Integer nota
    ) {
        return trabalhoService.buscarPorTituloENota(palavra, nota);
    }
}
