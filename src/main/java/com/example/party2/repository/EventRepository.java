package com.example.party2.repository;

import com.example.party2.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event,Long> {
}
