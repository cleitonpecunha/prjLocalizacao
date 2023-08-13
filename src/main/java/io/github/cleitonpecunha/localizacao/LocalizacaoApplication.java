package io.github.cleitonpecunha.localizacao;

import io.github.cleitonpecunha.localizacao.domain.entity.Cidade;
import io.github.cleitonpecunha.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicializando a aplicação");

		//System.out.println("Inserindo Cidades");
		//cidadeService.salvarCidade();

//		cidadeService.ListarCidadeOrdenadaPorNome();
//
//		System.out.println(" ");
//
//		cidadeService.ListarCidadeOrdenadaPorHabitante();
//
//		System.out.println(" ");
//
//		cidadeService.ListarCidadeOrdenadaPorRegiao();
//
//		System.out.println(" ");
//
//		var cidade = new Cidade(null,null, "AL", null,null);
//		cidadeService.filtroDinamico(cidade).forEach(System.out::println);
//
//		System.out.println(" ");
//
//		cidadeService.listarCidadesPorNomeLike();
//
//		System.out.println(" ");
//
//		cidadeService.listarCidadesPorRegiaoLike();
//
//		System.out.println(" ");
//
//		cidadeService.ListarCidadeHabitanteMenorQue();
//
//		System.out.println(" ");
//
//		cidadeService.ListarCidadeHabitanteMaiorQue();
//
//		System.out.println(" ");

		//cidadeService.ListarCidadeByNomeSpec();

		//var cidade = new Cidade(null,null,null,"NORDESTE", 1000000L);
		//cidadeService.ListarCidadeFiltroDinamicoSpec(cidade);

		cidadeService.listarCidadesPorNomeSqlNativo();

	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}
