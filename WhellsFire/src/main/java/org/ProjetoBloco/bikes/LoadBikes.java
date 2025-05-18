package org.ProjetoBloco.bikes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class LoadBikes {

    @Bean
    CommandLineRunner initDatabase(RepositoryBike repository) {
        return args -> {
            repository.save(new Bikes("caloi", "speed", "azul", "masculino", new BigDecimal("200.00")));
            repository.save(new Bikes("Caloi", "Speed", "Azul", "Masculino", new BigDecimal("200.00")));
            repository.save(new Bikes("Trek", "Marlin", "Preto", "Feminino", new BigDecimal("350.50")));
            repository.save(new Bikes("Specialized", "Rockhopper", "Vermelho", "Masculino", new BigDecimal("420.75")));
            repository.save(new Bikes("Scott", "Aspect", "Verde", "Feminino", new BigDecimal("390.99")));
            repository.save(new Bikes("Giant", "Defy", "Branco", "Masculino", new BigDecimal("500.00")));
            repository.save(new Bikes("Cannondale", "Trail", "Amarelo", "Feminino", new BigDecimal("480.20")));
            repository.save(new Bikes("Caloi", "Elite", "Cinza", "Masculino", new BigDecimal("310.30")));
            repository.save(new Bikes("Trek", "Domane", "Azul", "Feminino", new BigDecimal("650.00")));
            repository.save(new Bikes("Specialized", "Allez", "Preto", "Masculino", new BigDecimal("450.10")));
            repository.save(new Bikes("Scott", "Solace", "Vermelho", "Feminino", new BigDecimal("470.80")));
            repository.save(new Bikes("Giant", "Talon", "Laranja", "Masculino", new BigDecimal("280.00")));
            repository.save(new Bikes("Cannondale", "Synapse", "Branco", "Feminino", new BigDecimal("530.40")));
            repository.save(new Bikes("Caloi", "City", "Preto", "Masculino", new BigDecimal("220.00")));
            repository.save(new Bikes("Trek", "FX", "Verde", "Feminino", new BigDecimal("300.00")));
            repository.save(new Bikes("Specialized", "CruX", "Azul", "Masculino", new BigDecimal("400.50")));
            repository.save(new Bikes("Scott", "Addict", "Cinza", "Feminino", new BigDecimal("600.00")));
            repository.save(new Bikes("Giant", "Escape", "Preto", "Masculino", new BigDecimal("270.00")));
            repository.save(new Bikes("Cannondale", "F-Si", "Vermelho", "Feminino", new BigDecimal("580.00")));
            repository.save(new Bikes("Caloi", "Vulcan", "Amarelo", "Masculino", new BigDecimal("330.00")));
            repository.save(new Bikes("Trek", "Marlin 7", "Azul", "Feminino", new BigDecimal("370.00")));



        };
    }
    }
