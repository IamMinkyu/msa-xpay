package com.xpay.banking.adapter.in.web;

import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class BankingController {

  @GetMapping("/banking")
  public String banking() {
    return "banking";
  }
}
