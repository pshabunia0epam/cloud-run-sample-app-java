package com.example.gpsolab.fact;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fact {
  private String subject;
  private String fact;
}
