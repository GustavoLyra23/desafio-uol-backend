package org.gustavolyra.uolbackenddesafio.domain.models.dto;

import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;

public record JogadorDTO(String nome, String email,
                         String telefone, Grupo grupo) {
}
