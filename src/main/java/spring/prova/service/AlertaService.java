package spring.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.prova.entity.Alerta;
import spring.prova.repository.AlertaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    // Método para cadastrar um novo alerta
    public Alerta cadastrarAlerta(Alerta alerta) {
        // Validando se a data/hora de geração foi informada
        if (alerta.getDataHoraGeracao() == null) {
            alerta.setDataHoraGeracao(LocalDateTime.now()); // Se não informada, seta a data/hora atual
        }

        // Validando se o nível foi informado
        if (alerta.getNivel() == null) {
            alerta.setNivel(5); // Se não informado, define nível 5
        }

        return alertaRepository.save(alerta); // Salva o alerta no banco de dados
    }

    // Método para listar todos os alertas
    public List<Alerta> listarTodosAlertas() {
        return alertaRepository.findAll(); // Retorna todos os registros da tabela
    }

    // Método para buscar alertas com data/hora de geração superior a um parâmetro e nível inferior a outro parâmetro
    public List<Alerta> buscarPorDataHoraGeracaoENivel(LocalDateTime dataHoraGeracao, Integer nivel) {
        return alertaRepository.findByDataHoraGeracaoAndNivel(dataHoraGeracao, nivel); // Executa a consulta personalizada
    }
}