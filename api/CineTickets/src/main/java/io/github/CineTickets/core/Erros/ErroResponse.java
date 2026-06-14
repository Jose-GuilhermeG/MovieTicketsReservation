package io.github.CineTickets.core.Erros;

import java.util.List;

public record ErroResponse(int Status ,List<FieldErr> erros) {
}
