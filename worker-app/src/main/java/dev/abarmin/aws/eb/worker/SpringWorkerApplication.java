package dev.abarmin.aws.eb.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.abarmin.aws.eb.common.config.AppConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringWorkerApplication {
    public static void main(final String... args) {
        SpringApplication.run(SpringWorkerApplication.class, args);
    }
}
