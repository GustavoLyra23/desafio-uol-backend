package org.gustavolyra.uolbackenddesafio.domain.gateways.db;

import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;

import java.util.List;

public interface JogadorRepository {
    Jogador create(Jogador jogador);

    List<Jogador> findAll(int page, int size);
}
