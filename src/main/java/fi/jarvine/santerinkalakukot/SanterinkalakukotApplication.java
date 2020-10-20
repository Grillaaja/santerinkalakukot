package fi.jarvine.santerinkalakukot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.jarvine.santerinkalakukot.domain.Kalakukko;
import fi.jarvine.santerinkalakukot.domain.KalakukkoRepository;

@SpringBootApplication
public class SanterinkalakukotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanterinkalakukotApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cDemo(KalakukkoRepository kkrepository) {
		return (args) -> {
			kkrepository.save(new Kalakukko("Testikala", 0.4, "Mies", "Punainen"));
			kkrepository.save(new Kalakukko("Testikukko", 2.1, "Naaras", "Keltainen"));
		};
	}

}
