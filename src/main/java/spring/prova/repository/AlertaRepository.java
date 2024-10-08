package spring.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.prova.entity.Alerta;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    // Consulta personalizada para buscar alertas com data/hora de geração superior e nível inferior aos parâmetros
    @Query("SELECT a FROM Alerta a WHERE a.dataHoraGeracao > :dataHoraGeracao AND a.nivel < :nivel")
    List<Alerta> findByDataHoraGeracaoAndNivel(@Param("dataHoraGeracao") LocalDateTime dataHoraGeracao, @Param("nivel") Integer nivel);
}