package br.com.unoesc.academicolegadopub;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class AcademicoLegadoPubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicoLegadoPubApplication.class, args);
	}

}
