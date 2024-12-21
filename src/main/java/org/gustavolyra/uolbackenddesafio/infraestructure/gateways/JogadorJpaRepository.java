package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import org.gustavolyra.uolbackenddesafio.infraestructure.entities.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JogadorJpaRepository extends JpaRepository<JogadorEntity, UUID> {
}
