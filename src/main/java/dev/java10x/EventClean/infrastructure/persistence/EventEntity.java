package dev.java10x.EventClean.infrastructure.persistence;

import dev.java10x.EventClean.core.Enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Eventos")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String identificador;
    private LocalDateTime dataInicioEvento;
    private LocalDateTime dataFimEvento;
    private String localDoEvento;
    private Integer capacidade;
    private String organizador;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoDeEvento;

    public EventEntity() {
    }

    public EventEntity(Long id, String nome, String descricao, String identificador, LocalDateTime dataInicioEvento, LocalDateTime dataFimEvento, String localDoEvento, Integer capacidade, String organizador, TipoEvento tipoDeEvento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.identificador = identificador;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.localDoEvento = localDoEvento;
        this.capacidade = capacidade;
        this.organizador = organizador;
        this.tipoDeEvento = tipoDeEvento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDateTime getDataInicioEvento() {
        return dataInicioEvento;
    }

    public void setDataInicioEvento(LocalDateTime dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public LocalDateTime getDataFimEvento() {
        return dataFimEvento;
    }

    public void setDataFimEvento(LocalDateTime dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public String getLocalDoEvento() {
        return localDoEvento;
    }

    public void setLocalDoEvento(String localDoEvento) {
        this.localDoEvento = localDoEvento;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public TipoEvento getTipoDeEvento() {
        return tipoDeEvento;
    }

    public void setTipoDeEvento(TipoEvento tipoDeEvento) {
        this.tipoDeEvento = tipoDeEvento;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", identificador='" + identificador + '\'' +
                ", dataInicioEvento=" + dataInicioEvento +
                ", dataFimEvento=" + dataFimEvento +
                ", localDoEvento='" + localDoEvento + '\'' +
                ", capacidade=" + capacidade +
                ", organizador='" + organizador + '\'' +
                ", tipoDeEvento=" + tipoDeEvento +
                '}';
    }
}
