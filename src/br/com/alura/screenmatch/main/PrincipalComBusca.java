package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String search = "";
        List<Titulo> titulos = new ArrayList<>();

        System.out.println("Escreva sua key da api do OMDb: ");
        String apiKey = scanner.nextLine();

        while (!search.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca: ");
            search = scanner.nextLine();

            if(search.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                String address = "http://omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=" + apiKey;

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println(titulo);

                titulos.add(titulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço.");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }


        }
        System.out.println(titulos);

        FileWriter writer = new FileWriter("filmes.json");
        writer.write(gson.toJson(titulos));
        writer.close();

        System.out.println("O programa finanlizou corretamente!");
    }
}
