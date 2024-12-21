package org.gustavolyra.uolbackenddesafio.domain.enums;

public enum Grupo {

    VINGADORES("Vingadores", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("Liga da Justiça", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    private String nome;
    private String url;

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    Grupo(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

}
