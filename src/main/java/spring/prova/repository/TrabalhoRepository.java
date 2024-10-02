package spring.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.prova.entity.Trabalho;

import java.util.List;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:palavra% AND t.nota > :nota")
    List<Trabalho> findByTituloContainingAndNotaGreaterThan(
        @Param("palavra") String palavra,
        @Param("nota") Integer nota
    );
}