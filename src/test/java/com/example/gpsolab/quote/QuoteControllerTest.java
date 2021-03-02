package com.example.gpsolab.quote;

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
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getQuote() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/quote"))
        .andExpect(status().isOk())
        .andExpect(content().json("{author:testName,quote:testQuote}"));
  }

  @TestConfiguration
  static class TestConfig {

    @Bean
    public Supplier<Quote> testQuoteSupplier() {
      return Quote.builder().author("testName").quote("testQuote")::build;
    }
  }
}
