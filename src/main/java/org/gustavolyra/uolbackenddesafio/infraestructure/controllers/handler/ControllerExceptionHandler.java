package org.gustavolyra.uolbackenddesafio.infraestructure.controllers.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e, HttpServletRequest request) {
        var error = new ErrorDTO(Instant.now(), 500, e.getClass().getName(), request.getServletPath());
        return ResponseEntity.status(500).body(error);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleDbUniqueException(Exception e, HttpServletRequest request) {
        var status = 400;
        var error = new ErrorDTO(Instant.now(), status, e.getClass().getName(), request.getServletPath());
        return ResponseEntity.status(status).body(error);
    }


}
