package org.gustavolyra.uolbackenddesafio.infraestructure.controllers;

import org.gustavolyra.uolbackenddesafio.application.service.JogadorService;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorDTO;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/jogador")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping()
    ResponseEntity<JogadorReponseDTO> create(JogadorDTO jogadorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.create(jogadorDTO));
    }

    @GetMapping()
    ResponseEntity<List<JogadorReponseDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(jogadorService.findAll(pageable.getPageNumber(), pageable.getPageSize()));
    }


}

