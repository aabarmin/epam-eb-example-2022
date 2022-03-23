package dev.abarmin.aws.eb.worker;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.abarmin.aws.eb.common.model.Invoice;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WorkerInvoiceController {
    private final InvoiceProcessor invoiceProcessor;

    @PostMapping
    public void process(final @RequestBody Invoice invoice) {
        invoiceProcessor.process(invoice);
    }
}
