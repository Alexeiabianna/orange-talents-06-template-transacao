package com.alexei.transacao;

public class CartaoResposta {

    private String id;
    private String email;

    @Deprecated
    public CartaoResposta() {
    }

    public CartaoResposta(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
