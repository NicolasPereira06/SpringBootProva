package spring.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import spring.prova.entity.Trabalho;
import spring.prova.repository.TrabalhoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    // Método para cadastro de trabalho
    public Trabalho cadastrarTrabalho(Trabalho trabalho) {
        // Verifica se o título e o grupo estão preenchidos
        if (!StringUtils.hasText(trabalho.getTitulo()) || !StringUtils.hasText(trabalho.getGrupo())) {
            throw new IllegalArgumentException("Título e grupo são obrigatórios.");
        }

        // Se a data de entrega não estiver preenchida, usa a data/hora atual
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        // Salva o trabalho no banco de dados
        return trabalhoRepository.save(trabalho);
    }

    // Método para listar todos os registros
    public List<Trabalho> listarTodos() {
        return trabalhoRepository.findAll();
    }

    // Método para buscar trabalhos com base na palavra no título e nota superior a um número
    public List<Trabalho> buscarPorTituloENota(String palavra, Integer nota) {
        return trabalhoRepository.findByTituloContainingAndNotaGreaterThan(palavra, nota);
    }
}
