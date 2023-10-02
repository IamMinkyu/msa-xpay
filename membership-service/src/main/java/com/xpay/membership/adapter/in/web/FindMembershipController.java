package com.xpay.membership.adapter.in.web;

import com.xpay.membership.application.port.in.FindMembershipCommand;
import com.xpay.membership.application.port.in.FindMembershipUseCase;
import com.xpay.membership.domain.Membership;
import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;
    @GetMapping(path="/membership/{membershipId}")
    ResponseEntity<Membership> findMembershipById(@PathVariable String membershipId) {

        FindMembershipCommand command = FindMembershipCommand.builder()
            .membershipId(membershipId)
            .build();
        Membership membership = findMembershipUseCase.findMembership(command);
        return ResponseEntity.ok(membership);
    }
}
