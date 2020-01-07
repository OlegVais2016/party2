package com.example.party2.model.entity;

import com.example.party2.exception.TypeNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum EventType {

    TOPICS(1, "topics"),
    EXERCISES(2, "exercises");
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static EventType getByName(String name) {
        if (name == null) {
            return EventType.TOPICS;
        }

        return Arrays.stream(values())
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException
                        (String.format("Item type with name [%s] does not exist",
                                name)));

    }

    public static EventType getById(Integer eventTypeId) {
        if (eventTypeId == null) {
            return EventType.TOPICS;
        }

        return Arrays.stream(values())
                .filter(x -> x.getId().equals(eventTypeId))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException
                        (String.format("Item type with ID [%s] does not exist",
                                eventTypeId)));

    }
}
