package com.example.party2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @ManyToOne
    private Member arranger;
    @Convert(converter = EventStatusConverter.class)
    private EventStatus eventStatus;
    private EventType eventType;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String city;
    private String street;
    private String description;
    private Integer entranceFee;
    @ManyToMany
    private List<Member> participants;
}
