package imdl.scalator.controller;

import imdl.scalator.domain.Escala;
import imdl.scalator.domain.input.EscalaInput;
import imdl.scalator.service.EscalaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("v1/escala")
public class EscalaController {

    private final EscalaService escalaService;

    public EscalaController(EscalaService escalaService) {
        this.escalaService = escalaService;
    }

    @GetMapping
    @Operation(summary = "Lista com todas as escalas.")
    public List<Escala> listEscalas(){
        return escalaService.findAllEscalas();
    }

    @GetMapping("/{mes}")
    @Operation(summary = "Lista com todas as escalas de um determinado mes.")
    public List<Escala> listInPeriodo(){
        return escalaService.findMonthEscalas();
    }

    @PostMapping
    @Operation(summary = "Criar uma nova escala.")
    public Escala createEscala(@RequestBody EscalaInput input){
        return escalaService.create(input);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma escala.")
    public Escala updateEscala(@PathVariable UUID escalaId, @RequestBody EscalaInput input){
        return escalaService.update(escalaId, input);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar uma escala.")
    public void deleteMusica(@PathVariable UUID id){
        escalaService.deleteEscala(id);
    }

    @PostMapping("/musica/{id}")
    @Operation(summary = "Adiciona uma música na escala.")
    public Escala addMusicaInEscala(@PathVariable UUID escalaId, @RequestParam UUID musicaId){
        return escalaService.addMusicaInEscala(escalaId, musicaId);
    }
}
