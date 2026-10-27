package com.marcasluxo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação principal que ativa a autoconfiguração e o escaneamento de componentes do Spring Boot
@SpringBootApplication
public class MarcasLuxoApplication {

	// Método principal (main) que inicializa o Spring Boot e o servidor Tomcat embutido
	public static void main(String[] args) {
		SpringApplication.run(MarcasLuxoApplication.class, args);
	}

}
