package br.com.fatec.chopperhousegames.core.domain.entity;

import br.com.fatec.chopperhousegames.core.domain.exception.DomainException;

import java.io.Serializable;
import java.util.Arrays;


public enum Status implements Serializable {

    EM_PROCESSAMENTO("EM PROCESSAMENTO"),
    PAGAMENTO_REALIZADO("PAGAMENTO REALIZADO"),
    ENVIADO_PARA_A_TRANSPORTADORA("ENVIADO PARA A TRANSPORTADORA"),
    EM_TRANSPORTE("EM TRANSPORTE"),
    ENTREGUE("ENTREGUE"),
    TROCA_SOLICITADA("TROCA SOLICITADA"),
    TROCA_RECUSADA("TROCA RECUSADA"),
    TROCA_ACEITA("TROCA ACEITA"),
    PRODUTO_ENVIADO_PARA_TROCA("PRODUTO ENVIADO PARA TROCA"),
    PRODUTO_RECEBIDO_PARA_TROCA("PRODUTO RECEBIDO PARA TROCA"),
    TROCA_REALIZADA("TROCA REALIZADA"),
    CANCELAMENTO_REALIZADO("CANCELAMENTO REALIZADO"),
    CANCELAMENTO_SOLICITADO("CANCELAMENTO SOLICITADO"),
    CANCELAMENTO_RECUSADO("CANCELAMENTO RECUSADO");

    Status(String status) {
        this.nome = status;
    }

    private String nome;

    public static Status getByNomeStatus(String nome) {
        return Arrays.stream(values()).filter(status -> status.nome.equalsIgnoreCase(nome)).findFirst().orElseThrow(DomainException::ch002StatusNaoEncontrado);
    }
}
