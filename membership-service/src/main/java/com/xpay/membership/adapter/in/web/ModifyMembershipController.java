package com.xpay.membership.adapter.in.web;

import com.xpay.membership.application.port.in.ModifyMembershipCommand;
import com.xpay.membership.application.port.in.ModifyMembershipUseCase;
import com.xpay.membership.domain.Membership;
import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;
    @PatchMapping(path="/membership")
    Membership modifyMembership(@RequestBody ModifyMembershipRequest request) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
            .membershipId(request.getMembershipId())
            .name(request.getName())
            .email(request.getEmail())
            .address(request.getAddress())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return modifyMembershipUseCase.modifyMembership(command);
    }
}
