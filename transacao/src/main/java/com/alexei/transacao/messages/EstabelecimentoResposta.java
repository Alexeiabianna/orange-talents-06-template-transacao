package com.alexei.transacao.messages;

import com.alexei.transacao.model.Estabelecimento;

public class EstabelecimentoResposta {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoResposta() {
    }

    public EstabelecimentoResposta(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }

}
