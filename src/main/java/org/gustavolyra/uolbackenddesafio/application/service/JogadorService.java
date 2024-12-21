package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;

import java.util.List;

public interface JogadorService {
    Jogador create(Jogador jogador);

    List<JogadorReponseDTO> findAll(int page, int size);

}
