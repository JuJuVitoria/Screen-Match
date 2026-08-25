package br.com.alura.screenmatch.view;

import br.com.alura.screenmatch.model.EpisodeInfo;
import br.com.alura.screenmatch.model.SeasonInfo;
import br.com.alura.screenmatch.model.SerieInfo;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.DataConvert;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private final String API_ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "6585022c";
    private String url;

    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private DataConvert dataConvert = new DataConvert();

    public void showMenu() {
        System.out.println("Digite o nome da série: ");
        var serieName = scanner.nextLine();
        serieName = serieName.replace(" ", "+").toLowerCase().strip();

        //https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c
        url = API_ADDRESS + serieName + "&apikey=" + API_KEY;
        System.out.println(url);

        var json = consumeAPI.getData(url);
        SerieInfo serieInfo = dataConvert.getData(json, SerieInfo.class);
        System.out.println(serieInfo);

        List<SeasonInfo> seasons = new ArrayList<>();

        for (int i = 1; i <= serieInfo.numberSeasons(); i++) {
            json = consumeAPI.getData(API_ADDRESS + serieName + "&season=" + i + "&apikey=" + API_KEY);
            SeasonInfo seasonInfo = dataConvert.getData(json, SeasonInfo.class);
            seasons.add(seasonInfo);
        }

        seasons.forEach(System.out::println);

        seasons.forEach( t -> t.episodes().forEach(e -> System.out.println(e.title())));
    }
}
