package br.com.fatec.chopperhousegames.core.domain.exception;

public class DomainException extends RuntimeException {

    private final String codigo;

    public DomainException(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
    }

    public static DomainException ch001RegistroNaoEncontrado() {
        return new DomainException("CH-001", "Registro não foi encontrado.");
    }

    public static DomainException ch002StatusNaoEncontrado() {
        return new DomainException("CH-002", "Status não foi encontrado.");
    }

    public String getCodigo() {
        return codigo;
    }
}
