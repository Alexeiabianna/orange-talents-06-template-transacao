package com.alexei.transacao.messages;

import com.alexei.transacao.model.Transacao;
import com.alexei.transacao.repository.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ConsultaComprasController {

    @Autowired
    private TransacaoRepository transacaoRepository;
    
    @GetMapping("{idCartao}")
    public ResponseEntity<?> busca(@PathVariable String idCartao) {

        if(!transacaoRepository.existsByCartao(idCartao)) {
            return ResponseEntity.notFound().build();
        }
        
        Pageable pageable = PageRequest.of(0, 10, Sort.by("efetivadaEm").descending());
        Page<Transacao> comprasRecentes = transacaoRepository.findByCartao(idCartao, pageable);        

        return ResponseEntity.ok().body(comprasRecentes);

    }
}
