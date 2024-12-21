package org.gustavolyra.uolbackenddesafio.domain.models.dto;

public class JogadorReponseDTO {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String codinome;
    private String grupo;

    public JogadorReponseDTO() {
    }

    public JogadorReponseDTO(String id, String nome, String email, String telefone, String codinome, String grupo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.codinome = codinome;
        this.grupo = grupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String nome;
        private String email;
        private String telefone;
        private String codinome;
        private String grupo;

        public Builder id(String id) {
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

        public Builder grupo(String grupo) {
            this.grupo = grupo;
            return this;
        }

        public JogadorReponseDTO build() {
            return new JogadorReponseDTO(id, nome, email, telefone, codinome, grupo);
        }
    }
}