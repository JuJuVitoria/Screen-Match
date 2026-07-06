package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainComListas {
    static void main(String[] args) {
        Serie serie1 = new Serie("Lost", 2000);
        Filme filme1 = new Filme("O poderoso chefão", 1970, 180);
        filme1.avalia(7);
        Filme filme2 = new Filme("Avatar", 2023, 200);
        filme2.avalia(10);
        Filme filme3 = new Filme("Dogville", 2003, 200);
        filme3.avalia(8);

        Filme f1 = filme1;

        List<Titulo> lista = new ArrayList<>();
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

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
