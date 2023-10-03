package com.xpay.banking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpay.banking.adapter.in.web.RegisterBankAccountRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterBankAccountControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void testRegisterBankAccount() throws Exception {
    // given
    RegisterBankAccountRequest request = new RegisterBankAccountRequest();
    request.setMembershipId("1");
    request.setBankName("bankName");
    request.setBankAccountNumber("bankAccountNumber");
    request.setValid(true);

    // when
    mockMvc.perform(post("/banking/account/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.membershipId").value("1"))
        .andExpect(jsonPath("$.bankName").value("bankName"))
        .andExpect(jsonPath("$.bankAccountNumber").value("bankAccountNumber"))
        .andExpect(jsonPath("$.linkedStatusIsValid").value(true));
  }
}
