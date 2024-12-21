package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.gateways.db.JogadorRepository;
import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorDTO;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;
import org.gustavolyra.uolbackenddesafio.utils.MapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Random;

@Service
public class JogadorServiceImpl implements JogadorService {

    private final JogadorRepository jogadorRepository;
    private final GroupHeroService groupHeroService;

    public JogadorServiceImpl(JogadorRepository jogadorRepository, GroupHeroService groupHeroService) {
        this.jogadorRepository = jogadorRepository;
        this.groupHeroService = groupHeroService;
    }

    @Transactional
    @Override
    public JogadorReponseDTO create(final JogadorDTO dto) {
        var availableCodinomes = findAvailableCodinomes(dto);
        var jogador = MapperUtil.map(dto, Jogador.class);
        jogador.setCodinome(setRandomCodinome(availableCodinomes));
        var jogadorCriado = jogadorRepository.create(jogador);
        return mapJogadorToDto(jogadorCriado);
    }

    @Transactional(readOnly = true)
    @Override
    public List<JogadorReponseDTO> findAll(final int page, final int size) {
        var jogadores = jogadorRepository.findAll(page, size);
        return jogadores.stream().map(jogador -> MapperUtil.map(jogador, JogadorReponseDTO.class)).toList();
    }

    @Transactional
    protected List<String> findAvailableCodinomes(final JogadorDTO jogador) {
        var codinomes = groupHeroService.fetchGroupData(jogador.grupo());
        var usedCodinomes = jogadorRepository.findUsedCodinomes(jogador.grupo());
        List<String> availableCodinomes = codinomes.stream().filter(codinome -> !usedCodinomes.contains(codinome)).toList();
        return availableCodinomes;
    }

    public String setRandomCodinome(List<String> availableCodinomes) {
        Random random = new Random();
        int randomIndex = random.nextInt(availableCodinomes.size());
        return availableCodinomes.get(randomIndex);
    }

    private JogadorReponseDTO mapJogadorToDto(Jogador jogador) {
        return JogadorReponseDTO.builder()
                .id(jogador.getId().toString())
                .nome(jogador.getNome())
                .email(jogador.getEmail())
                .telefone(jogador.getTelefone())
                .grupo(jogador.getGrupo().getNome())
                .codinome(jogador.getCodinome())
                .build();
    }

}