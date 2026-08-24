package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoDeAnoException extends RuntimeException {
    private final String message;

    public ErroDeConversaoDeAnoException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return "\n" + this.message;
    }
}
