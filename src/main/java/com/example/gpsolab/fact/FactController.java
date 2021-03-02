package com.example.gpsolab.fact;

import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fact")
public class FactController {

  @Autowired
  private Supplier<Fact> factSupplier;

  @GetMapping
  public Fact factOfTheDay() {
    return factSupplier.get();
  }
}
