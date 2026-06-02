package br.com.alura.screenmatch.models;

public class Filme extends Titulo {
    private String diretor;

    public Filme(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        super(nome, anoDeLancamento);
        this.setDuracaoEmMinutos(duracaoEmMinutos);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}