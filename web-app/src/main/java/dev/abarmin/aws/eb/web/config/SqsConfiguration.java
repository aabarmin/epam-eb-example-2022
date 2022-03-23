package dev.abarmin.aws.eb.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.abarmin.aws.eb.common.config.AppConfiguration;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
@RequiredArgsConstructor
public class SqsConfiguration {
    private final AppConfiguration configuration;

    @Bean
    public SqsClient sqsClient() {
      return SqsClient.builder()
          .region(Region.of(configuration.getQueueRegion()))
          .build();
    }
}
