package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {
    public EventEntity toEntity(Event event) {
        return new EventEntity(
                event.id(),
                event.nome(),
                event.descricao(),
                event.identificador(),
                event.dataInicioEvento(),
                event.dataFimEvento(),
                event.localDoEvento(),
                event.capacidade(),
                event.organizador(),
                event.tipoDeEvento()
        );

    }

    public Event toDomain(EventEntity event){
            return new Event(
                    event.getId(),
                    event.getNome(),
                    event.getDescricao(),
                    event.getIdentificador(),
                    event.getDataInicioEvento(),
                    event.getDataFimEvento(),
                    event.getLocalDoEvento(),
                    event.getCapacidade(),
                    event.getOrganizador(),
                    event.getTipoDeEvento()
            );
    }
}
