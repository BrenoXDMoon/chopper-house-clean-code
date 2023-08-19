package br.com.fatec.chopperhousegames.core.domain;

public class DomainException extends RuntimeException {

    private final String codigo;

    public DomainException(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
    }

    public static DomainException ch001RegistroNaoEncontrado(){
        return new DomainException("CH-001", "Registro não foi encontrado.");
    }

    public String getCodigo() {
        return codigo;
    }
}
