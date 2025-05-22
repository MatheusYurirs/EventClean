package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exceptions.NotFoundEventException;

public class FiltrarIdentificadorUseCaseImpl implements FiltrarIdentificadorUseCase {

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Event execute(String identificador) {
        return eventoGateway.filtroPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Evento com identificador: " +  identificador + " nao encontrado"));
    }
}
