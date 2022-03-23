package dev.abarmin.aws.eb.worker;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.common.model.InvoiceStatus;
import dev.abarmin.aws.eb.common.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CronProcessor {
    private final InvoiceRepository invoiceRepository;

    @GetMapping("/cron")
    public void process() {
        log.info("Cron execution started");
        Collection<Invoice> records = invoiceRepository.findAllByStatus(InvoiceStatus.IN_PROCESS);
        log.info("{} records to process", records.size());
        
        records.forEach(record -> record.setStatus(InvoiceStatus.PROCESSED));
        records.forEach(invoiceRepository::save);
    }
}