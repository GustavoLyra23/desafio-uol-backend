package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.gateways.db.JogadorRepository;
import org.gustavolyra.uolbackenddesafio.infraestructure.models.entities.JogadorEntity;
import org.gustavolyra.uolbackenddesafio.utils.MapperUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryImpl implements JogadorRepository {

    private final JogadorDataRepository jogadorDataRepository;

    public UserRepositoryImpl(JogadorDataRepository jogadorDataRepository) {
        this.jogadorDataRepository = jogadorDataRepository;
    }

    @Override
    public Jogador create(Jogador jogador) {
        return MapperUtil.map(jogadorDataRepository.save(MapperUtil.map(jogador, JogadorEntity.class)), Jogador.class);
    }

    @Override
    public List<Jogador> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return jogadorDataRepository.findAll(pageRequest).map(jogadorEntity ->
                MapperUtil.map(jogadorEntity, Jogador.class)).toList();
    }
}
