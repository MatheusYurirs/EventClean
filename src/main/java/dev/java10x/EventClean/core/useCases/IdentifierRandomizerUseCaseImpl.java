package dev.java10x.EventClean.core.useCases;

import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exceptions.DuplicateEventException;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdentifierRandomizerUseCaseImpl implements IdentifierRandomizerUseCase{

    private final EventoGateway eventoGateway;

    public IdentifierRandomizerUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public String execute() {
        for (int i = 0; i < 10; i++) {
            String identificador = geraAlfaNumber();
            if(!eventoGateway.eventoExistePorIdentificador(identificador)){
                return identificador;
            }
        }
        throw new DuplicateEventException("Evento com esse identificador já existe");
    }

    private String geraAlfaNumber() {
        String letras = IntStream.range(0,3)
                .mapToObj(i -> (char) ThreadLocalRandom.current().nextInt('A', 'Z'+1))
                .map(String::valueOf)
                .collect(Collectors.joining());

        int numero = ThreadLocalRandom.current().nextInt(0,1000);
        String numeros = String.format("%03d", numero);



        return letras + numeros;
    }
}
