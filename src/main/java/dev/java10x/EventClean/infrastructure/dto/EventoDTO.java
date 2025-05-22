package dev.java10x.EventClean.infrastructure.dto;

import dev.java10x.EventClean.core.Enums.TipoEvento;
import lombok.Builder;

import java.time.LocalDateTime;


public record EventoDTO(Long id,
                        String nome,
                        String descricao,
                        String identificador,
                        LocalDateTime dataInicioEvento,
                        LocalDateTime dataFimEvento,
                        String localDoEvento,
                        Integer capacidade,
                        String organizador,
                        TipoEvento tipoDeEvento) {
    
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String descricao;
        private String identificador;
        private LocalDateTime dataInicioEvento;
        private LocalDateTime dataFimEvento;
        private String localDoEvento;
        private Integer capacidade;
        private String organizador;
        private TipoEvento tipoDeEvento;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder identificador(String identificador) {
            this.identificador = identificador;
            return this;
        }

        public Builder dataInicioEvento(LocalDateTime dataInicioEvento) {
            this.dataInicioEvento = dataInicioEvento;
            return this;
        }

        public Builder dataFimEvento(LocalDateTime dataFimEvento) {
            this.dataFimEvento = dataFimEvento;
            return this;
        }

        public Builder localDoEvento(String localDoEvento) {
            this.localDoEvento = localDoEvento;
            return this;
        }

        public Builder capacidade(Integer capacidade) {
            this.capacidade = capacidade;
            return this;
        }

        public Builder organizador(String organizador) {
            this.organizador = organizador;
            return this;
        }

        public Builder tipoDeEvento(TipoEvento tipoDeEvento) {
            this.tipoDeEvento = tipoDeEvento;
            return this;
        }

        public EventoDTO build() {
            return new EventoDTO(
                    id, nome, descricao, identificador,
                    dataInicioEvento, dataFimEvento,
                    localDoEvento, capacidade, organizador, tipoDeEvento
            );
        }
    }

}
