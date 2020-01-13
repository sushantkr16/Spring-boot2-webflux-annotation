package com.sk.learn.resource.router;

import com.sk.learn.handler.InvitationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class InvitationRouter {

	@Bean
	public RouterFunction<ServerResponse> route(InvitationHandler invitationHandler) {

		return RouterFunctions
			.route(RequestPredicates.GET("/events/invite").and(
					RequestPredicates.accept(MediaType.APPLICATION_JSON)), invitationHandler::invite);
	}
}
