package com.example.gpsolab.hello;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Defines a controller to handle HTTP requests.
 */
@Log
@Controller
public final class HelloWorldController {

  /**
   * Redirects to <tt>/hello</tt> endpoint.
   *
   * @return redirect instructions
   */
  @GetMapping("/")
  public RedirectView redirectWithRedirectAttributes() {
    return new RedirectView("/hello");
  }

  /**
   * Serves a thymeleaf template for the "Hello World!" page
   *
   * @return the index view template
   */
  @GetMapping("/hello")
  public String helloWorld(Model model) {
    // Get Cloud Run environment variables.
    String revision = System.getenv("K_REVISION") == null ? "???" : System.getenv("K_REVISION");
    String service = System.getenv("K_SERVICE") == null ? "???" : System.getenv("K_SERVICE");

    // Set variables in html template.
    model.addAttribute("revision", revision);
    model.addAttribute("service", service);
    return "hello";
  }
}
