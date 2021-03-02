package com.example.gpsolab.hello;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getPageView() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/hello"))
        .andExpect(status().isOk())
        .andExpect(view().name("hello"))
        .andExpect(content().string(Matchers.containsString("Hello World!")));
  }
}
