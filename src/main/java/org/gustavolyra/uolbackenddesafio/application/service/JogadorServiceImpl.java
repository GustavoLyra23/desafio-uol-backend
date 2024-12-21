package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;
import org.gustavolyra.uolbackenddesafio.domain.repository.JogadorRepository;

import java.util.List;

public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorServiceImpl(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public Jogador create(Jogador jogador) {
        return null;
    }

    @Override
    public List<JogadorReponseDTO> findAll(int page, int size) {
        return List.of();
    }
}
