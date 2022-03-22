package dev.abarmin.aws.eb.web.worker;

import dev.abarmin.aws.eb.common.model.Invoice;

/**
 * @author Aleksandr Barmin
 */
public interface WorkerAdapter {
  void submit(Invoice invoice);
}
