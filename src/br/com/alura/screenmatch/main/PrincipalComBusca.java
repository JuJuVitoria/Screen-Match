package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var search = scanner.nextLine();

        System.out.println("Escreva sua key da api do OMDb: ");
        var apiKey = scanner.nextLine();
        String address = "http://omdbapi.com/?t=" + search + "&apikey=" + apiKey;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(tituloOmdb);
        Titulo titulo = new Titulo(tituloOmdb);
        System.out.println(titulo.getNome());
        System.out.println(titulo.getAnoDeLancamento());
        System.out.println(titulo.getDuracaoEmMinutos());
    }
}
