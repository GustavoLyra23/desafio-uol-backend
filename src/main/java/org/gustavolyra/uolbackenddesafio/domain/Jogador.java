package org.gustavolyra.uolbackenddesafio.domain;

import java.util.UUID;

public class Jogador {

    private UUID id;
    private String email;
    private String telefone;
    private String codinome;
    private Grupo grupo;

    public Jogador() {
    }

    public Jogador(String email, String telefone, String codinome, Grupo grupo) {
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.grupo = grupo;
    }


}
