package com.xpay.banking.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpay.banking.application.port.out.GetMembershipPort;
import com.xpay.banking.application.port.out.MembershipStatus;
import com.xpay.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter implements GetMembershipPort {

  private final CommonHttpClient commonHttpClient;
  private final String membershipServiceUrl;

  public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
                                  @Value("${service.membership.url}") String membershipServiceUrl) {

    this.commonHttpClient = commonHttpClient;
    this.membershipServiceUrl = membershipServiceUrl;
  }
  @Override
  public MembershipStatus getMembership(String membershipId) {

    // call membership service
//    String url = String.join("/", "http://membership-service:8080", membershipId);
    String url = this.membershipServiceUrl + "/membership/" + membershipId;
    try {

      String jsonResponse = this.commonHttpClient.sendGetRequest(url).body();
      ObjectMapper mapper = new ObjectMapper();
      Membership membership = mapper.readValue(jsonResponse, Membership.class);

      if (membership.isValid()) {
        return new MembershipStatus(membershipId, true);
      } else {
        return new MembershipStatus(membershipId, false);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
