package com.BabyLion.Spring.repository;

import com.BabyLion.Spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속하는 순간 메서드들이 자동 제공, 서비스에서 호출 하면 끝
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);

    boolean existsByName(String name);
}
