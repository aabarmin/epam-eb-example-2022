package dev.abarmin.aws.eb.web.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Aleksandr Barmin
 */
@Data
@ConfigurationProperties(prefix = "app.configuration")
public class AppConfiguration {
  @Value("table-name")
  private String tableName;

  @Value("table-region")
  private String tableRegion;

  @Value("queue-name")
  private String queueName;

  @Value("queue-region")
  private String queueRegion;
}
