package com.example.party2.model.dto.event;

import com.example.party2.model.entity.EventStatus;
import com.example.party2.model.entity.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventResponse {

    private String firstName;
    private String title;
    private EventStatus eventStatus;
    private EventType eventType;
    private LocalDate date;
    private LocalTime time;
    private String city;
    private String street;
    private String description;
    private Integer entranceFee;


}
