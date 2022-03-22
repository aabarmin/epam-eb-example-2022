package dev.abarmin.aws.eb.common.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aleksandr Barmin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
  private String id;
  private LocalDate createdAt;
  private String description;
  private InvoiceStatus status;
  private LocalDate updatedAt;
}
