package dev.java10x.EventClean.core.entities;

import dev.java10x.EventClean.core.Enums.TipoEvento;

import java.time.LocalDateTime;

public record Event(Long id,
                    String nome,
                    String descricao,
                    String identificador,
                    LocalDateTime dataInicioEvento,
                    LocalDateTime dataFimEvento,
                    String localDoEvento,
                    String organizador,
                    TipoEvento tipoDeEvento) {
}
