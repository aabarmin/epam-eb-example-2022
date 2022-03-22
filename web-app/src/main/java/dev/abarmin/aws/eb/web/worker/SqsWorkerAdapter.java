package dev.abarmin.aws.eb.web.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.web.config.AppConfiguration;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

/**
 * @author Aleksandr Barmin
 */
@Component
@RequiredArgsConstructor
public class SqsWorkerAdapter implements WorkerAdapter {
  private final SqsClient sqsClient;
  private final AppConfiguration configuration;
  private final ObjectMapper objectMapper;
  private final Map<String, String> queueUrls = new HashMap<>();

  @Override
  public void submit(Invoice invoice) {
    final String queueUrl = queueUrls.computeIfAbsent(configuration.getQueueName(), this::getQueueUrl);
    final SendMessageRequest request = SendMessageRequest.builder()
        .queueUrl(queueUrl)
        .messageBody(getMessageBody(invoice))
        .build();

    sqsClient.sendMessage(request);
  }

  @SneakyThrows
  private String getMessageBody(Invoice invoice) {
    return objectMapper.writeValueAsString(invoice);
  }

  private String getQueueUrl(final String queueName) {
    final GetQueueUrlRequest request = GetQueueUrlRequest.builder()
        .queueName(queueName)
        .build();
    final GetQueueUrlResponse response = sqsClient.getQueueUrl(request);
    return response.queueUrl();
  }
}
