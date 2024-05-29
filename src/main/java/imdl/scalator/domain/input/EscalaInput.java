package imdl.scalator.domain.input;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class EscalaInput {
    private UUID ministro;
    private UUID violao;
    private UUID teclado;
    private UUID baixo;
    private UUID bateria;
    private List<UUID> backs;
    private UUID musicas;
    private LocalDate data;
    private String observacoes;
}