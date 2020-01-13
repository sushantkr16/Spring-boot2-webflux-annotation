package com.sk.learn.resource.router;

import com.sk.learn.handler.EventHandler;
import com.sk.learn.handler.InvitationHandler;
import com.sk.learn.resource.dto.Event;
import com.sk.learn.resource.dto.Events;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class EventRouter {

    @Bean
    public RouterFunction<ServerResponse> routeEventWithEventId(EventHandler eventHandler) {
        return RouterFunctions
                .route(GET("/events/details/{eventId}").and(accept(MediaType.APPLICATION_JSON)),
                        eventHandler::getEventDetail);
    }

    @Bean
    public RouterFunction<ServerResponse> routeEvent(EventHandler eventHandler) {

        return RouterFunctions.route(GET("/events/details"),
                req -> ok().body(eventHandler.getAllEventDetails(), Events.class));
    }
}
