package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Event;
import dev.java10x.EventClean.core.useCases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.useCases.CriarEventoUseCase;
import dev.java10x.EventClean.core.useCases.FiltrarIdentificadorUseCase;
import dev.java10x.EventClean.infrastructure.dto.EventoDTO;
import dev.java10x.EventClean.infrastructure.mapper.EventDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final FiltrarIdentificadorUseCase filtrarIdentificadorUseCase;
    private final EventDTOMapper eventDTOMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, BuscarEventoUseCase buscarEventoUseCase, FiltrarIdentificadorUseCase filtrarIdentificadorUseCase, EventDTOMapper eventDTOMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.filtrarIdentificadorUseCase = filtrarIdentificadorUseCase;
        this.eventDTOMapper = eventDTOMapper;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String,Object>> criarEvento(@RequestBody EventoDTO eventoDTO){
        Event novoEvento = criarEventoUseCase.execute(eventDTOMapper.toDomain(eventoDTO));

        Map<String, Object> response = new HashMap<>();
        response.put("Messagem: ", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do Evento:",eventDTOMapper.toDTO(novoEvento));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<EventoDTO> buscarEvento(){
        return  buscarEventoUseCase.execute()
                .stream()
                .map(eventDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<Map<String, Object>> buscarEventoPorIdentificador(@PathVariable String identificador){
        Event event = filtrarIdentificadorUseCase.execute(identificador);

        Map<String, Object> response  = new HashMap<>();
        response.put("Messagem: ", "Evento encontrado");
        response.put("Dados do Evento: ", eventDTOMapper.toDTO(event));
        return ResponseEntity.ok(response) ;
    }

}
