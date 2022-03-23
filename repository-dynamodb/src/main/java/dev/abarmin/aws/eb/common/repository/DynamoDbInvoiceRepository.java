package dev.abarmin.aws.eb.common.repository;

import dev.abarmin.aws.eb.common.config.AppConfiguration;
import dev.abarmin.aws.eb.common.model.Invoice;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

/**
 * @author Aleksandr Barmin
 */
@Component
@RequiredArgsConstructor
public class DynamoDbInvoiceRepository implements InvoiceRepository {
  private final DynamoDbClient dynamoDbClient;
  private final AppConfiguration appConfiguration;
  private final InvoiceTransformer transformer;

  @Override
  public Collection<Invoice> findAll() {
    final ScanRequest request = ScanRequest.builder()
        .limit(100)
        .tableName(appConfiguration.getTableName())
        .build();

    return dynamoDbClient.scan(request)
        .items()
        .stream()
        .map(transformer::toModel)
        .collect(Collectors.toList());
  }

  @Override
  public Invoice save(Invoice invoice) {
    final UpdateItemRequest request = UpdateItemRequest.builder()
        .tableName(appConfiguration.getTableName())
        .key(Map.of(
            "id",
            AttributeValue.builder().s(invoice.getId()).build()
        ))
        .attributeUpdates(transformer.toRecord(invoice))
        .build();

    final UpdateItemResponse response = dynamoDbClient.updateItem(request);

    return invoice;
  }

  @Override
  public Optional<Invoice> findOne(String key) {
    final GetItemRequest request = GetItemRequest.builder()
        .tableName(appConfiguration.getTableName())
        .key(Map.of(
          "id",
          AttributeValue.builder().s(key).build()
        ))
        .build();
    
    final GetItemResponse response = dynamoDbClient.getItem(request);
    if (!response.hasItem()) {
      return Optional.empty();
    }
    final Invoice invoice = transformer.toModel(response.item());
    return Optional.of(invoice);
  }
}
