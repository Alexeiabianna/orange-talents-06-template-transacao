package com.alexei.transacao.repository;

import com.alexei.transacao.model.Transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    Page<Transacao> findByCartao(String idCartao, Pageable pageable);
    boolean existsByCartao(String idCartao);
    
}
