package com.example.party2.repository;

import com.example.party2.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("select m from Member m where m.firstName = :firstName")
    Member findByName(@Param("firstName") String firstName);
    Member findByEmail(String email);

}
