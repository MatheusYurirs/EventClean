package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.infrastructure.exceptions.DuplicateEventException;
import dev.java10x.EventClean.core.gateway.EventoGateway;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;
    private final IdentifierRandomizerUseCase identifierRandomizerUseCase;


    public CriarEventoUseCaseImpl(EventoGateway eventoGateway, IdentifierRandomizerUseCase identifierRandomizerUseCase) {
        this.eventoGateway = eventoGateway;
        this.identifierRandomizerUseCase = identifierRandomizerUseCase;
    }

    @Override
    public Event execute(Event event) {
        String identificador = event.identificador();

        if (identificador == null || identificador.isBlank()) {
            identificador = identifierRandomizerUseCase.execute() ;
            event = new Event(
                    event.id(),
                    event.nome(),
                    event.descricao(),
                    identificador,
                    event.dataInicioEvento(),
                    event.dataFimEvento(),
                    event.localDoEvento(),
                    event.capacidade(),
                    event.organizador(),
                    event.tipoDeEvento()
            );
        }

        if(eventoGateway.eventoExistePorIdentificador(event.identificador())){
            throw new DuplicateEventException("Evento com identificador: "
                    + event.identificador() +
                    " já está em uso para outro evento");
        }
        return eventoGateway.criarEvento(event);
    }
}
