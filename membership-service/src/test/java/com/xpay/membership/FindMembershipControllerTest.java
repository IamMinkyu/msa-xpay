package com.xpay.membership;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpay.membership.adapter.in.web.RegisterMembershipRequest;
import com.xpay.membership.domain.Membership;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FindMembershipControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Test
    public void testFindMembership() throws Exception {
        RegisterMembershipRequest request = new RegisterMembershipRequest("mklee", "iamdevstar@gmail.com", "ongoulro",false);
        mockMvc.perform(
            MockMvcRequestBuilders.post("/membership/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)));

        String membershipId = "1";
        mockMvc.perform(get("/membership/" + membershipId))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
