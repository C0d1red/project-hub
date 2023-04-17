package ru.c0d1red.projecthub.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.c0d1red.projecthub")
@EnableJpaRepositories("ru.c0d1red.projecthub")
@EntityScan("ru.c0d1red.projecthub")
public class ProjectHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectHubApplication.class, args);
    }

}
