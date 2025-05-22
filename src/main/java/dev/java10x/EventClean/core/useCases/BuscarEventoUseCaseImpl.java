package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase {

    public EventoGateway eventoGateway;

    public BuscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }


    @Override
    public List<Event> execute() {
        return eventoGateway.listarEventos();
    }
}
