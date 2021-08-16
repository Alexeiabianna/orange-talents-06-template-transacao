package com.alexei.transacao.messages;

import com.alexei.transacao.model.Cartao;

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

    public Cartao toCartao() {
        return new Cartao(id, email);
    }

}
