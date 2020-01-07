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

    @OneToOne
    private Member arranger;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String city;
    private String street;
    private String house;
    @ManyToMany
    private List<Member> participants;
}
