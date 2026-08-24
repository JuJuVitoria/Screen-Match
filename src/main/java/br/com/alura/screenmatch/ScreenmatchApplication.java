package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.EpisodeInfo;
import br.com.alura.screenmatch.model.SeasonInfo;
import br.com.alura.screenmatch.model.SerieInfo;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeAPI consumeAPI = new ConsumeAPI();
		DataConvert dataConvert = new DataConvert();

		var json = consumeAPI.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		SerieInfo serieInfo = dataConvert.getData(json, SerieInfo.class);
		System.out.println(serieInfo);

		List<SeasonInfo> seasons = new ArrayList<>();

		for (int i = 1; i <= serieInfo.numberSeasons(); i++) {
			json = consumeAPI.getData("https://www.omdbapi.com/?t=" + serieInfo.title() + "&season=" + i + "&apikey=6585022c");
			SeasonInfo seasonInfo = dataConvert.getData(json, SeasonInfo.class);
			seasons.add(seasonInfo);
		}

		seasons.forEach(System.out::println);

		json = consumeAPI.getData("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		EpisodeInfo episodeInfo = dataConvert.getData(json, EpisodeInfo.class);
		System.out.println(episodeInfo);
	}
}
