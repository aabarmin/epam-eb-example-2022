package dev.abarmin.aws.eb.common.model;

import java.time.LocalDate;
import lombok.Data;

/**
 * @author Aleksandr Barmin
 */
@Data
public class Invoice {
  private Long id;
  private LocalDate createdAt;
  private String description;
  private InvoiceStatus status;
  private LocalDate updatedAt;
}
