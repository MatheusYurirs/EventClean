package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Event criarEvento(Event event);

    List<Event> listarEventos();

    boolean eventoExistePorIdentificador(String identificador);

    Optional<Event> filtroPorIdentificador(String identificador);

}
