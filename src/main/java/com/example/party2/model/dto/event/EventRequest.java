package com.example.party2.model.dto.event;

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
public class EventRequest {

    private String title;
    private EventType eventType;
    private LocalDate date;
    private LocalTime time;
    private String city;
    private String street;
    private String description;
    private Integer entranceFee;
}
