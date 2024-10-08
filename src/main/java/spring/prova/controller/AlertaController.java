package spring.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.prova.entity.Alerta;
import spring.prova.service.AlertaService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    // Rota para cadastro de um novo alerta (POST /alerta/cadastrar)
    @PostMapping("/cadastrar")
    public ResponseEntity<Alerta> cadastrarAlerta(@RequestBody Alerta alerta) {
        Alerta novoAlerta = alertaService.cadastrarAlerta(alerta);
        return ResponseEntity.ok(novoAlerta); // Retorna o alerta cadastrado
    }

    // Rota para listar todos os registros de alertas (GET /alerta/listar)
    @GetMapping("/listar")
    public ResponseEntity<List<Alerta>> listarTodosAlertas() {
        List<Alerta> alertas = alertaService.listarTodosAlertas();
        return ResponseEntity.ok(alertas); // Retorna a lista de todos os alertas
    }

    // Rota para buscar alertas por data/hora de geração superior e nível inferior (GET /alerta/buscar)
    @GetMapping("/buscar")
    public ResponseEntity<List<Alerta>> buscarPorDataHoraGeracaoENivel(
            @RequestParam("dataHoraGeracao") String dataHoraGeracao,
            @RequestParam("nivel") Integer nivel) {

        LocalDateTime dataGeracao = LocalDateTime.parse(dataHoraGeracao);
        List<Alerta> alertas = alertaService.buscarPorDataHoraGeracaoENivel(dataGeracao, nivel);
        return ResponseEntity.ok(alertas); // Retorna a lista de alertas filtrada
    }
}