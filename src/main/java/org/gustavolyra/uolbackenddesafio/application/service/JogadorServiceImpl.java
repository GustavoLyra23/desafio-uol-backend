package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.gateways.db.JogadorRepository;
import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorDTO;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;
import org.gustavolyra.uolbackenddesafio.utils.MapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorServiceImpl(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Transactional
    @Override
    public JogadorReponseDTO create(final JogadorDTO jogador) {
        var jogadorCriado = jogadorRepository.create(MapperUtil.map(jogador, Jogador.class));
        return MapperUtil.map(jogadorCriado, JogadorReponseDTO.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<JogadorReponseDTO> findAll(final int page, final int size) {
        var jogadores = jogadorRepository.findAll(page, size);
        return jogadores.stream().map(jogador -> MapperUtil.map(jogador, JogadorReponseDTO.class)).toList();
    }
}
