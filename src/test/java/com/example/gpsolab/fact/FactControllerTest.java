package com.example.gpsolab.fact;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(FactController.class)
public class FactControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getFact() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/fact"))
        .andExpect(status().isOk())
        .andExpect(content().json("{subject:testName,fact:testFact}"));
  }

  @TestConfiguration
  static class TestConfig {

    @Bean
    public Supplier<Fact> testQuoteSupplier() {
      return Fact.builder().subject("testName").fact("testFact")::build;
    }
  }
}