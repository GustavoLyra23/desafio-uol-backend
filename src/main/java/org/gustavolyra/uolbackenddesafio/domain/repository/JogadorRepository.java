package org.gustavolyra.uolbackenddesafio.domain.repository;

import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;

import java.util.List;

public interface JogadorRepository {
    Jogador create(Jogador jogador);

    List<Jogador> findAll();

}
