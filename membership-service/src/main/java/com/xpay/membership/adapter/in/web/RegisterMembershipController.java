package com.xpay.membership.adapter.in.web;

import com.xpay.membership.application.port.in.RegisterMembershipCommand;
import com.xpay.membership.application.port.in.RegisterMembershipUseCase;
import com.xpay.membership.domain.Membership;
import com.xpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;
    @PostMapping(path="/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {

        //request -> command
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMembershipUseCase.registerMembership(command);
    }
}
