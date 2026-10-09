package com.marcasluxo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication eh a anotacao principal que inicializa toda a configuracao automatica do Spring Boot
@SpringBootApplication
public class MarcasLuxoApplication {

    // Metodo main: ponto de entrada que roda a aplicacao e sobe o servidor Tomcat na porta 8080
    public static void main(String[] args) {
        SpringApplication.run(MarcasLuxoApplication.class, args);
    }

}
