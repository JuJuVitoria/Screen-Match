package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.models.Episodio;
import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 1970, 180);
        filme1.exibeFichaTecnica();

        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);
        System.out.println("Total de avaliações: " + filme1.getTotalDeAvaliacoes());
        System.out.println(filme1.pegaMedia());

        Serie serie1 = new Serie("Lost", 2000);
        serie1.exibeFichaTecnica();
        serie1.setTemporadas(10);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + serie1.getDuracaoEmMinutos());

        Filme filme2 = new Filme("Avatar", 2023, 200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie1);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme1);

        Episodio episodio1 = new Episodio();
        episodio1.setNumero(1);
        episodio1.setSerie(serie1);
        episodio1.setTotalVisualizacoes(300);
        filtro.filtra(episodio1);

        var filme3 = new Filme("Dogville", 2003, 200);
        filme3.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filme3);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());
    }
}
