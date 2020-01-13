package com.sk.learn.repository;

import com.sk.learn.resource.dto.Event;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private Map<String, Event> eventMap = new HashMap<>();

    @PostConstruct
    public void init() {
        eventMap.put("12012020", new Event("12012020", "birthday", "kids birthday party"));
        eventMap.put("11012020", new Event("11012020", "house-warming", "new house warming"));
        eventMap.put("10012020", new Event("10012020", "marriage", "marriage"));
    }


    @Override
    public Mono<Event> getById(String id) {
        return Mono.justOrEmpty(eventMap.get(id)).log();
    }

    @Override
    public Flux<Event> getAll() {
        return Flux.fromIterable(eventMap.values()).log();
    }

    @Override
    public Mono<Void> save(Mono<Event> event) {
        return event.map(e -> {
            System.out.println("saved:" + e.getEventId());
            eventMap.put(e.getEventId(), e);
            return e;
        }).log().then();
    }

    @Override
    public Mono<Void> saveAll(Flux<Event> events) {
        return events.map(event -> {
            System.out.println("saved:" + event.getEventId());
            this.eventMap.put(event.getEventId(), event);
            return event;
        }).log().then();
    }

    @Override
    public Mono<Event> update(String eventId, Mono<Event> event) {
        return event.map(e -> eventMap.put(eventId, e)).log();
    }

    @Override
    public Mono<Void> delete(long id) {
        eventMap.remove(id);
        return Mono.empty();
    }
}
