package com.xpay.banking.application.port.out;

public interface GetMembershipPort {
  MembershipStatus getMembership(String membershipId);
}
