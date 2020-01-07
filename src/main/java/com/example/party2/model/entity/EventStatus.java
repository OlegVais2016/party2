package com.example.party2.model.entity;

import com.example.party2.exception.TypeNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@Getter
public enum EventStatus {

    PENDING(1,"pending"),
    DONE(2,"done");

    private Integer id;
    private String name;

    @JsonValue
    public String getName() {
        return name;
    }
    @JsonCreator
    public static EventStatus getByName(String name){
        if(name == null) {
            return EventStatus.PENDING;
        }
        return Arrays.stream(values())
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException
                        (String.format("Item status with name [%s] does not exist",
                                name)));
    }

    public static EventStatus getById(Integer id){
        if(id == null){
            return EventStatus.PENDING;
        }
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException
                        (String.format("Item status with ID [%s] does not exist",
                                id)));

    }
    public EventStatus getNextPhase() {
        return Arrays
                .stream(values())
                .sorted(Comparator.comparing(EventStatus::getId))
                .filter(x -> x.getId().equals(this.getId() + 1))
                .findFirst()
                .orElse(EventStatus.DONE);
    }
}
