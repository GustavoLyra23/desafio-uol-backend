package org.gustavolyra.uolbackenddesafio.infraestructure.factory;

import org.gustavolyra.uolbackenddesafio.application.service.GroupHeroService;
import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;
import org.gustavolyra.uolbackenddesafio.infraestructure.gateways.LigaDaJusticaGatewayImpl;
import org.gustavolyra.uolbackenddesafio.infraestructure.gateways.VingadoresGatewayImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupHeroFactory implements GroupHeroService {

    private final LigaDaJusticaGatewayImpl ligaDaJusticaGateway;
    private final VingadoresGatewayImpl vingadoresGateway;

    public GroupHeroFactory(LigaDaJusticaGatewayImpl ligaDaJusticaGateway, VingadoresGatewayImpl vingadoresGateway) {
        this.ligaDaJusticaGateway = ligaDaJusticaGateway;
        this.vingadoresGateway = vingadoresGateway;
    }

    @Override
    public List<String> fetchGroupData(Grupo grupo) {
        return switch (grupo) {
            case VINGADORES -> vingadoresGateway.fetch(grupo.getUrl());
            case LIGA_DA_JUSTICA -> ligaDaJusticaGateway.fetch(grupo.getUrl());
        };
    }
}