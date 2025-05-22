package dev.java10x.EventClean.infrastructure.gateway;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infrastructure.persistence.EventEntity;
import dev.java10x.EventClean.infrastructure.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EventoRepositoryGateway implements EventoGateway {


    private final EventRepository eventRepository;
    private final EventoEntityMapper mapper;

    public EventoRepositoryGateway(EventRepository eventRepository, EventoEntityMapper mapper) {
        this.eventRepository = eventRepository;
        this.mapper = mapper;
    }

    @Override
    public Event criarEvento(Event event) {
        EventEntity eventEntity = eventRepository.save(mapper.toEntity(event));
         return mapper.toDomain(eventEntity);

    }

    @Override
    public List<Event> listarEventos() {
        List<EventEntity> eventEntities = eventRepository.findAll();
         return eventEntities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean eventoExistePorIdentificador(String identificador) {
        return eventRepository.findAll()
                .stream()
                .anyMatch(event -> event.getIdentificador()
                        .equals(identificador));
    }

    @Override
    public Optional<Event> filtroPorIdentificador(String identificador) {
         return eventRepository.findByIdentificador(identificador);
    }
}
