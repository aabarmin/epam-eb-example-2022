package dev.abarmin.aws.eb.web;

import dev.abarmin.aws.eb.web.config.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Aleksandr Barmin
 */
@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class SpringWebApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringWebApplication.class, args);
  }
}
