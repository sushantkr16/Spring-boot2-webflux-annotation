package com.sk.learn.resource;

import com.sk.learn.repository.EventRepository;
import com.sk.learn.resource.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/events/details")
public class EventResource {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    private Flux<Event> getAllEvents() {
        return eventRepository.getAll();
    }

    @GetMapping("/{eventId}")
    private Mono<Event> getEventByEventId(@PathVariable String eventId) {
        return eventRepository.getById(eventId);
    }
}
