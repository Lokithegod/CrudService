package com.gmail.kss95kss.CrudService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudServiceApplication.class, args);
    }

/*    @Bean
    FlywayMigrationStrategy cleanMigrateStrategy() {
        return flyway -> {
            flyway.repair();
        };
    }*/

}
