package fi.jarvine.santerinkalakukot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jarvine.santerinkalakukot.domain.Kalakukko;
import fi.jarvine.santerinkalakukot.domain.KalakukkoRepository;
import fi.jarvine.santerinkalakukot.domain.Specie;
import fi.jarvine.santerinkalakukot.domain.SpecieRepository;

@SpringBootApplication
public class SanterinkalakukotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanterinkalakukotApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cDemo(KalakukkoRepository kkrepository, SpecieRepository srepository) {
		return (args) -> {
			srepository.save(new Specie("Fish"));
			srepository.save(new Specie("Bird"));
			
			kkrepository.save(new Kalakukko("Testikala", 0.4, "Kolli", "Punainen", srepository.findByName("Fish").get(0), 24.444, 24.444));
			kkrepository.save(new Kalakukko("Testikukko", 2.1, "Naaras", "Keltainen", srepository.findByName("Bird").get(0), 23.333, 23.333));
		};
	}

}
