package com.xpay.money.application.port.out;

public interface GetMembershipPort {
  public MembershipStatus getMembership(String membershipId);
}
