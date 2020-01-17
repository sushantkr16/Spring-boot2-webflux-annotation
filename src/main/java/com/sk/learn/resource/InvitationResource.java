package com.sk.learn.resource;


import com.sk.learn.resource.dto.Invitation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events/invite")
public class InvitationResource {

    @GetMapping()
    private Mono<Invitation> getInvitation() {
        Invitation invitation = new Invitation();
        invitation.setInvitationType("birthday");
        invitation.setInvitationText("You'r invited to the party");
        return Mono.justOrEmpty(invitation);
    }
}
