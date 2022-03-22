package dev.abarmin.aws.eb.web;

import dev.abarmin.aws.eb.common.model.Invoice;
import dev.abarmin.aws.eb.web.service.InvoiceService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Aleksandr Barmin
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class InvoiceController {
  private final InvoiceService invoiceService;

  private Invoice createInvoice() {
    return Invoice.builder()
        .createdAt(LocalDate.now())
        .description("Dummy description")
        .build();
  }

  @GetMapping
  public ModelAndView findAll(final ModelAndView modelAndView) {
    modelAndView.setViewName("index");
    modelAndView.addObject("invoices", invoiceService.findAll());
    modelAndView.addObject("invoice", createInvoice());
    return modelAndView;
  }

  @PostMapping
  public RedirectView create(final @ModelAttribute Invoice invoice,
                             final RedirectView redirectView) {

    invoiceService.save(invoice);
    redirectView.setUrl("/");
    return redirectView;
  }
}
