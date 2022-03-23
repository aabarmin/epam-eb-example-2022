package dev.abarmin.aws.eb.common.repository;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.common.model.InvoiceStatus;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValueUpdate;

/**
 * @author Aleksandr Barmin
 */
@Component
public class InvoiceTransformer {
  public Invoice toModel(final Map<String, AttributeValue> record) {
    return Invoice.builder()
        .id(getString(record, "id"))
        .description(getString(record, "description"))
        .status(getStatus(record))
        .createdAt(getLocalDate(record, "createdAt"))
        .build();
  }

  public Map<String, AttributeValueUpdate> toRecord(final Invoice invoice) {
    final Map<String, AttributeValueUpdate> record = new HashMap<>();
    record.put("description", getString(invoice.getDescription()));
    record.put("status", getString(invoice.getStatus()));
    record.put("createdAt", getString(invoice.getCreatedAt()));
    return record;
  }

  private AttributeValueUpdate getString(final LocalDate value) {
    return AttributeValueUpdate.builder()
        .value(AttributeValue.builder().s(value.toString()).build())
        .build();
  }

  private AttributeValueUpdate getString(final InvoiceStatus status) {
    return AttributeValueUpdate.builder()
        .value(AttributeValue.builder().s(status.name()).build())
        .build();
  }

  private AttributeValueUpdate getString(final String value) {
    return AttributeValueUpdate.builder()
        .value(AttributeValue.builder().s(value).build())
        .build();
  }

  private LocalDate getLocalDate(final Map<String, AttributeValue> record, final String createdAt) {
    final String stringValue = record.get(createdAt).s();
    return LocalDate.parse(stringValue);
  }

  private String getString(final Map<String, AttributeValue> record, final String field) {
    return record.get(field).s();
  }

  private InvoiceStatus getStatus(final Map<String, AttributeValue> record) {
    final String stringValue = record.get("status").s();
    return InvoiceStatus.valueOf(stringValue);
  }
}
