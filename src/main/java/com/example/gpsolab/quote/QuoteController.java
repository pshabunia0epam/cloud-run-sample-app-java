package com.example.gpsolab.quote;

import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {

  @Autowired
  private Supplier<Quote> quoteSupplier;

  @GetMapping
  public Quote quoteOfTheDay() {
    return quoteSupplier.get();
  }
}
