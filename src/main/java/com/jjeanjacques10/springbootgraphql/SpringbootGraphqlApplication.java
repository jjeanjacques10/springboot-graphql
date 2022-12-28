package com.jjeanjacques10.springbootgraphql;

import com.jjeanjacques10.springbootgraphql.entity.Book;
import com.jjeanjacques10.springbootgraphql.entity.Wizard;
import com.jjeanjacques10.springbootgraphql.repository.BookRepository;
import com.jjeanjacques10.springbootgraphql.repository.WizardRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraphqlApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(WizardRepository wizardRepository, BookRepository bookRepository) {
        return args -> {
            Wizard rudeusGreyrat = wizardRepository.save(new Wizard(null, "Rudeus Greyrat"));
            Wizard roxyMigurdia = wizardRepository.save(new Wizard(null, "Roxy Migurdia"));
            bookRepository.saveAll(List.of(
                    new Book("Old fire dragon", "School of magic", rudeusGreyrat),
                    new Book("Old water dragon", "School of magic", roxyMigurdia),
                    new Book("Old air dragon", "School of magic", rudeusGreyrat)
            ));
        };
    }

}
