package dev.abarmin.aws.eb.web;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.common.model.InvoiceStatus;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Aleksandr Barmin
 */
@Service
public class InvoiceService {
  private final Collection<Invoice> invoices = new HashSet<>();

  public Collection<Invoice> findAll() {
    return invoices;
  }

  public Invoice save(final Invoice invoice) {
    if (invoice.getStatus() == null) {
      invoice.setStatus(InvoiceStatus.CREATED);
    }
    if (invoice.getId() == null) {
      invoice.setId(invoices.size() + 1L);
    }
    invoices.add(invoice);
    return invoice;
  }
}
