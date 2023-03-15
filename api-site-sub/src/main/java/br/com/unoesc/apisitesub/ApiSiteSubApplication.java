package br.com.unoesc.apisitesub;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ApiSiteSubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSiteSubApplication.class, args);
	}

}
