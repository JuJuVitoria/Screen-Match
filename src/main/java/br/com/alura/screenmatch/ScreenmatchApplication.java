package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.EpisodeInfo;
import br.com.alura.screenmatch.model.SeasonInfo;
import br.com.alura.screenmatch.model.SerieInfo;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.DataConvert;
import br.com.alura.screenmatch.view.Main;
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
		Main main = new Main();
		main.showMenu();
	}
}
