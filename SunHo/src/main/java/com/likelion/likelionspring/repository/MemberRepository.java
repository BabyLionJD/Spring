package com.likelion.likelionspring.repository;

import com.likelion.likelionspring.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);

    Page<Member> findByPart(String part, Pageable pageable);
}