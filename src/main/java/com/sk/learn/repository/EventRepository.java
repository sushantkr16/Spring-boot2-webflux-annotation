package com.sk.learn.repository;

import com.sk.learn.resource.dto.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventRepository {

    Mono<Event> getById(String id);
    Flux<Event> getAll();
    Mono<Void> save(Mono<Event> event);
    Mono<Void> saveAll(Flux<Event> events);
    Mono<Event> update(String eventId, Mono<Event> event);
    Mono<Void> delete(long id);
}
