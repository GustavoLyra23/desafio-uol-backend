package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;
import org.gustavolyra.uolbackenddesafio.infraestructure.models.entities.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JogadorDataRepository extends JpaRepository<JogadorEntity, UUID> {
    @Query("SELECT j.codinome FROM JogadorEntity j WHERE j.grupo = :group")
    List<String> findUsedCodinomes(@Param("group") Grupo group);
}
