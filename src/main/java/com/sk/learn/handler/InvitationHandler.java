package com.sk.learn.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class InvitationHandler {

	public Mono<ServerResponse> invite(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromObject("You are invited to the party!"));
	}
}
