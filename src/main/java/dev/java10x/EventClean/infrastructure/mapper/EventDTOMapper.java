package dev.java10x.EventClean.infrastructure.mapper;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infrastructure.dto.EventoDTO;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDTOMapper {

    public EventoDTO toDTO(Event event){
        return  new EventoDTO(
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

    public Event toDomain(EventoDTO eventoDTO){
        return new Event(
                eventoDTO.id(),
                eventoDTO.nome(),
                eventoDTO.descricao(),
                eventoDTO.identificador(),
                eventoDTO.dataInicioEvento(),
                eventoDTO.dataFimEvento(),
                eventoDTO.localDoEvento(),
                eventoDTO.capacidade(),
                eventoDTO.organizador(),
                eventoDTO.tipoDeEvento()
        );



    }


}
