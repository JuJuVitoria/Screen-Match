package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Titulo;

import java.util.ArrayList;

public class MainComListas {
    static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 1970, 180);
        Serie serie1 = new Serie("Lost", 2000);
        Filme filme2 = new Filme("Avatar", 2023, 200);
        Filme filme3 = new Filme("Dogville", 2003, 200);

        Filme f1 = filme1;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie1);
        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }

        }
    }
}
