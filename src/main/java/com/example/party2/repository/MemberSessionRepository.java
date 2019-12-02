package com.example.party2.repository;

import com.example.party2.model.entity.MemberSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSessionRepository extends JpaRepository <MemberSession,Long> {
    MemberSession findBySessionIdAndAndIsValidTrue(String sessionId);
}


