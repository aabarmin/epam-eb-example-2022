package dev.abarmin.aws.eb.common.repository;

import dev.abarmin.aws.eb.common.model.Invoice;
import java.util.Collection;

/**
 * @author Aleksandr Barmin
 */
public interface InvoiceRepository {
  /**
   * Find all the invoices.
   *
   * @return
   */
  Collection<Invoice> findAll();

  /**
   * Save an invoice.
   *
   * @param invoice
   * @return
   */
  Invoice save(Invoice invoice);
}
