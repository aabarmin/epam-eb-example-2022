package dev.abarmin.aws.eb.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWorkerApplication {
    public static void main(final String... args) {
        SpringApplication.run(SpringWorkerApplication.class, args);
    }
}
