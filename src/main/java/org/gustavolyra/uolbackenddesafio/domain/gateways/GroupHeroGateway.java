package org.gustavolyra.uolbackenddesafio.domain.gateways;

import java.util.List;

public interface GroupHeroGateway {
    List<String> fetch(String url);
}
