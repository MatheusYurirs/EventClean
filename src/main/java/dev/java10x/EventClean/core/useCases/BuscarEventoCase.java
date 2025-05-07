package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;

public interface BuscarEventoCase {

    public Event search(Long id);
}
