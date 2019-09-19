package Cartelera.cartelera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author flor
 *
 */
@EntityScan("Cartelera.cartelera.model")
@EnableJpaRepositories("Cartelera.cartelera.dao")
@ComponentScan("Cartelera.cartelera.controllers")
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}