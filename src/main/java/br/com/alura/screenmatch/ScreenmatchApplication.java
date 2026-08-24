package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SeriesInfo;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeAPI consumeAPI = new ConsumeAPI();
		var json = consumeAPI.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		DataConvert dataConvert = new DataConvert();
		SeriesInfo data = dataConvert.getData(json, SeriesInfo.class);
		System.out.println(data);
	}
}
