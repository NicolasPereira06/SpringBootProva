package spring.prova.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "alt_alerta")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alt_id")
    private Long id;

    @Column(name = "alt_mensagem", nullable = false)
    private String mensagem;

    @Column(name = "alt_detalhe")
    private String detalhe;

    @Column(name = "alt_data_hora_geracao", nullable = false)
    private LocalDateTime dataHoraGeracao;

    @Column(name = "alt_data_hora_verificacao")
    private LocalDateTime dataHoraVerificacao;

    @Column(name = "alt_nivel")
    private Integer nivel;

    // Construtores
    public Alerta() {
    }

    public Alerta(String mensagem, String detalhe, LocalDateTime dataHoraGeracao, LocalDateTime dataHoraVerificacao, Integer nivel) {
        this.mensagem = mensagem;
        this.detalhe = detalhe;
        this.dataHoraGeracao = dataHoraGeracao;
        this.dataHoraVerificacao = dataHoraVerificacao;
        this.nivel = nivel;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public LocalDateTime getDataHoraGeracao() {
        return dataHoraGeracao;
    }

    public void setDataHoraGeracao(LocalDateTime dataHoraGeracao) {
        this.dataHoraGeracao = dataHoraGeracao;
    }

    public LocalDateTime getDataHoraVerificacao() {
        return dataHoraVerificacao;
    }

    public void setDataHoraVerificacao(LocalDateTime dataHoraVerificacao) {
        this.dataHoraVerificacao = dataHoraVerificacao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}