package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorDTO;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;

import java.util.List;

public interface JogadorService {
    JogadorReponseDTO create(JogadorDTO dto);
    List<JogadorReponseDTO> findAll(int page, int size);

}
