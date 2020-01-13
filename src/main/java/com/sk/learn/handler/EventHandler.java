package com.sk.learn.handler;

import com.sk.learn.repository.EventRepository;
import com.sk.learn.resource.dto.Event;
import com.sk.learn.resource.dto.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class EventHandler {

    @Autowired
    EventRepository eventRepository;

    public Flux<Event> getAllEventDetails() {
        return eventRepository.getAll();
    }

    public Mono<ServerResponse> getEventDetail(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eventRepository.getById(request.pathVariable("eventId")), Event.class);
    }
}
