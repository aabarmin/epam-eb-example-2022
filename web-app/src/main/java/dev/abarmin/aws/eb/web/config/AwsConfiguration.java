package dev.abarmin.aws.eb.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.sqs.SqsClient;

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

  @Bean
  public SqsClient sqsClient() {
    return SqsClient.builder()
        .region(Region.of(configuration.getQueueRegion()))
        .build();
  }
}
