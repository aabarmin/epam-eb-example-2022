package dev.abarmin.aws.eb.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

/**
 * @author Aleksandr Barmin
 */
@Configuration
@RequiredArgsConstructor
public class AwsConfiguration {
  private final AppConfiguration configuration;

  @Bean
  public DynamoDbClient dynamoDbClient() {
    return DynamoDbClient.builder()
        .region(Region.of(configuration.getTableRegion()))
        .build();
  }
}
