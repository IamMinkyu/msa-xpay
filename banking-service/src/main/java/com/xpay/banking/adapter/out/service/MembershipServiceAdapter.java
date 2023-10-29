package com.xpay.membership.adapter.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpay.banking.application.port.out.GetMembershipPort;
import com.xpay.banking.application.port.out.Membership;
import com.xpay.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;

public class MembershipServiceAdapter implements GetMembershipPort {

  private final CommonHttpClient commonHttpClient;
  private final String membershipServiceUrl;

  public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
                                  @Value("${service.membership.url}") String membershipServiceUrl) {

    this.commonHttpClient = commonHttpClient;
    this.membershipServiceUrl = membershipServiceUrl;
  }
  @Override
  public Membership getMembership(String membershipId) {

    // call membership service
    String url = String.join("/", this.membershipServiceUrl, membershipId));
    try {
      String jsonResponse = this.commonHttpClient.sendGetRequest(url).body();
      ObjectMapper mapper = new ObjectMapper();
      Membership membership = mapper.readValue(jsonResponse, Membership.class);

      if (membership.isValid()) {
        return new Membership(membershipId, membership.getPoint());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // 실제로 http call
    //
    return null;
  }
}
