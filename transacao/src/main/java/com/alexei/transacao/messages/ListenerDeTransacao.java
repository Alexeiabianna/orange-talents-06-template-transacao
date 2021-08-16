package com.alexei.transacao.messages;

import com.alexei.transacao.repository.TransacaoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger log = LoggerFactory.getLogger(EventoDeTransacao.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        try {
            log.info("Id {}", eventoDeTransacao.getId());
            log.info("Valor {}", eventoDeTransacao.getValor());
            log.info("Efetivado em {}", eventoDeTransacao.getEfetivadaEm());
            log.info("Estabelecimento", eventoDeTransacao.getEstabelecimento());

            transacaoRepository.save(eventoDeTransacao.toTransacao());

        } catch (Exception e) {
            log.info("Transacao não persistida no sistema {}", eventoDeTransacao.getCartao());
        }
    }

}
