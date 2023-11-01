package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring!");
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite uma série para busca: ");
		var busca = leitura.nextLine();

		String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=4f059530";

		ConsumoAPI ca = new ConsumoAPI();
		String json = ca.obterDados(endereco);
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		leitura.close();
	}
}
