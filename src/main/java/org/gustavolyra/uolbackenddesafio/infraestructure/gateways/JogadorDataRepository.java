package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import org.gustavolyra.uolbackenddesafio.infraestructure.models.entities.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorDataRepository extends JpaRepository<JogadorEntity, UUID> {
}
