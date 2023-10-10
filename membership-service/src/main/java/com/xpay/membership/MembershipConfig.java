package com.xpay.membership;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xpay.common")
public class MembershipConfig {
  public static void main(String[] args) {
    System.out.println("MembershipConfig is created");
  }
}
