package com.alexei.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.alexei.transacao.messages.CartaoResposta;
import com.alexei.transacao.messages.EstabelecimentoResposta;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idCompra;
    private BigDecimal valor;

    @ManyToOne
    private Cartao cartao;
    @ManyToOne
    private Estabelecimento estabelecimento;
    private LocalDateTime efetivadaEm;

    public Transacao(String idCompra, BigDecimal valor, CartaoResposta cartao, EstabelecimentoResposta estabelecimento,
            LocalDateTime efetivadaEm) {
        this.idCompra = idCompra;
        this.valor = valor;
        this.cartao = cartao.toCartao();
        this.estabelecimento = estabelecimento.toEstabelecimento();
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}
