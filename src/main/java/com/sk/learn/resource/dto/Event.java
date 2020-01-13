package com.sk.learn.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private String eventId; //put date as event id
    private String eventType;
    private String eventDescription;
}
