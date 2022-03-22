package dev.abarmin.aws.eb.web.service;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.common.model.InvoiceStatus;
import dev.abarmin.aws.eb.web.worker.WorkerAdapter;
import dev.abarmin.aws.eb.web.repository.InvoiceRepository;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aleksandr Barmin
 */
@Service
@RequiredArgsConstructor
public class InvoiceService {
  private final InvoiceKeyGenerator keyGenerator;
  private final InvoiceRepository invoiceRepository;
  private final WorkerAdapter workerAdapter;

  public Collection<Invoice> findAll() {
    return invoiceRepository.findAll();
  }

  public Invoice save(final Invoice invoice) {
    if (invoice.getStatus() == null) {
      invoice.setStatus(InvoiceStatus.CREATED);
    }
    if (invoice.getId() == null) {
      invoice.setId(keyGenerator.generate());
    }

    final Invoice saved = invoiceRepository.save(invoice);

    if (saved.getStatus() == InvoiceStatus.CREATED) {
      workerAdapter.submit(saved);
    }
    return saved;
  }
}
