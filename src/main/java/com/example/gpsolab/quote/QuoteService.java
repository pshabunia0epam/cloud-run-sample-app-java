package com.example.gpsolab.quote;

import com.github.javafaker.Faker;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;

@Service
public class QuoteService implements Supplier<Quote> {

  private static final Faker FAKER = Faker.instance();

  @Override
  public Quote get() {
    return Quote.builder()
        .author("Master Yoda")
        .quote(FAKER.yoda().quote())
        .build();
  }
}
