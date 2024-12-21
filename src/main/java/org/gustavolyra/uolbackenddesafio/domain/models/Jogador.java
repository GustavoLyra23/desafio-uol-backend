package org.gustavolyra.uolbackenddesafio.domain.models;

import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;

import java.util.Objects;
import java.util.UUID;

public class Jogador {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    private String codinome;
    private Grupo grupo;

    public Jogador() {
    }

    public Jogador(UUID id, String nome, String email, String telefone, String codinome, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.grupo = grupo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Jogador jogador = (Jogador) object;
        return Objects.equals(email, jogador.email) && Objects.equals(codinome, jogador.codinome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, codinome);
    }

    public static class Builder {
        private UUID id;
        private String nome;
        private String email;
        private String telefone;
        private String codinome;
        private Grupo grupo;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder codinome(String codinome) {
            this.codinome = codinome;
            return this;
        }

        public Builder grupo(Grupo grupo) {
            this.grupo = grupo;
            return this;
        }

        public Jogador build() {
            return new Jogador(id, nome, email, telefone, codinome, grupo);
        }
    }
}