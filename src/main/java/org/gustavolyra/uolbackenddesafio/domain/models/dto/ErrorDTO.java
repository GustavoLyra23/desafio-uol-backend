package org.gustavolyra.uolbackenddesafio.domain.models.dto;

import java.time.Instant;

public record ErrorDTO(Instant timestamp, Integer status, String error, String path) {
}
