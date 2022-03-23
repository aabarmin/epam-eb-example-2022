package dev.abarmin.aws.eb.worker;

import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.common.model.InvoiceStatus;
import dev.abarmin.aws.eb.common.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InvoiceProcessor {
    private final InvoiceRepository invoiceRepository;

    public void process(final Invoice message) {
        final Optional<Invoice> invoiceOptional = invoiceRepository.findOne(message.getId());
        if (invoiceOptional.isEmpty()) {
            throw new RuntimeException(String.format(
                "Can't find invoice with key %s",
                message.getId()
            ));
        }
        final Invoice invoice = invoiceOptional.get();
        if (invoice.getStatus() == InvoiceStatus.CREATED) {
            invoice.setStatus(InvoiceStatus.IN_PROCESS);
        }
        invoiceRepository.save(invoice);
    }

}
