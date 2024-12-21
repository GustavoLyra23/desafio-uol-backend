package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;

import java.util.List;

public interface GroupHeroService {
    List<String> fetchGroupData(Grupo grupo);
}