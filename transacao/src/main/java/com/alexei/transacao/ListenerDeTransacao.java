package com.alexei.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class ListenerDeTransacao {

    private final Logger log = LoggerFactory.getLogger(EventoDeTransacao.class);

    @KafkaListener(topics = "${KAFKA_TRANSACTIONS_TOPIC:transacoes}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        System.out.println(eventoDeTransacao.getCartao());
        log.info("Id {}", eventoDeTransacao.getId());
        log.info("Valor {}", eventoDeTransacao.getValor());
        log.info("Efetivado em {}", eventoDeTransacao.getEfetivadaEm());
        log.info("Estabelecimento", eventoDeTransacao.getEstabelecimento());
    }
    
}
