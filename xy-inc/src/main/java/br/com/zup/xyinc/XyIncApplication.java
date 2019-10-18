package br.com.zup.xyinc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.xyinc.models.PontoInteresse;
import br.com.zup.xyinc.repositories.PontoInteresseRepository;

@SpringBootApplication
public class XyIncApplication implements CommandLineRunner {

	@Autowired
	private PontoInteresseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(XyIncApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		PontoInteresse p1 = new PontoInteresse(null, "Lanchonete", 27, 12);
		PontoInteresse p2 = new PontoInteresse(null, "Posto", 31, 18);
		PontoInteresse p3 = new PontoInteresse(null, "Joalheria", 15, 12);
		PontoInteresse p4 = new PontoInteresse(null, "Floricultura", 19, 21);
		PontoInteresse p5 = new PontoInteresse(null, "Pub", 12, 8);
		PontoInteresse p6 = new PontoInteresse(null, "Supermercado", 23, 6);
		PontoInteresse p7 = new PontoInteresse(null, "Churrascaria", 28, 2);
		
		repository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
	}

}
