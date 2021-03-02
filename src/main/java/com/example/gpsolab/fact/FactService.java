package com.example.gpsolab.fact;

import com.github.javafaker.Faker;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;

@Service
public class FactService implements Supplier<Fact> {

  private static final Faker FAKER = Faker.instance();

  @Override
  public Fact get() {
    return Fact.builder()
        .subject("Chuck Norris")
        .fact(FAKER.chuckNorris().fact())
        .build();
  }
}
