package dev.java10x.EventClean.infrastructure.beans;

import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoCase(EventoGateway eventoGateway, IdentifierRandomizerUseCase identifierRandomizerUseCase){
        return new CriarEventoUseCaseImpl(eventoGateway, identifierRandomizerUseCase);
    }

    @Bean
    public BuscarEventoUseCase buscarEventoCase(EventoGateway eventoGateway) {
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorUseCase filtroIdentificadorUseCase(EventoGateway eventoGateway){
        return new FiltrarIdentificadorUseCaseImpl(eventoGateway);
    }

    @Bean
    public IdentifierRandomizerUseCase identifierRandomizerUseCase(EventoGateway eventoGateway){
        return new IdentifierRandomizerUseCaseImpl(eventoGateway);
    }
}
