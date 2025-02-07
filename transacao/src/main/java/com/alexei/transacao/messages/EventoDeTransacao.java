package com.alexei.transacao.messages;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.alexei.transacao.model.Transacao;

public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private CartaoResposta cartao;
    private EstabelecimentoResposta estabelecimento;
    private LocalDateTime efetivadaEm;

    public EventoDeTransacao(String id, BigDecimal valor, CartaoResposta cartao,
            EstabelecimentoResposta estabelecimento, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CartaoResposta getCartao() {
        return cartao;
    }

    public EstabelecimentoResposta getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toTransacao() {
        return new Transacao(id, valor, cartao, estabelecimento, efetivadaEm);
    }

}
