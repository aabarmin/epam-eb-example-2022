package dev.abarmin.aws.eb.web.service;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Random key generator.
 *
 * @author Aleksandr Barmin
 */
@Component
public class InvoiceKeyGenerator {
  public String generate() {
    return UUID.randomUUID().toString();
  }
}
