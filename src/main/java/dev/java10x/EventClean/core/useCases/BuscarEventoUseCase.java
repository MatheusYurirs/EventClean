package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;

import java.util.List;

public interface BuscarEventoUseCase {

    public List<Event> execute();
}
