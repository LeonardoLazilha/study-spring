package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	//metodo da interface
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n\n-----------   APLICAÇÃO INICIADA   -----------\n");

		ConsumoApi consumoApi = new ConsumoApi();
		String json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&Season=1&apikey=62c49cb6");
		System.out.println("************  JSON");
		System.out.println(json + "\n");

		ConverterDados conversor = new ConverterDados();
		DadosSerie dadosSerie = conversor.obterDados(json, DadosSerie.class);
		System.out.println("************  Json modelado para DadosSerie:");
		System.out.println(dadosSerie);
	}
}
