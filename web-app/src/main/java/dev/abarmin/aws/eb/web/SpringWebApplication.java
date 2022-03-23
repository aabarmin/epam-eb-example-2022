package dev.abarmin.aws.eb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.abarmin.aws.eb.common.config.AppConfiguration;

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
