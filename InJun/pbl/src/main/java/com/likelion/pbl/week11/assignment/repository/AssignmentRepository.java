package com.likelion.pbl.week11.assignment.repository;

import com.likelion.pbl.week11.assignment.domain.Assignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMemberId(Long memberId);

    Page<Assignment> findByMemberId(Long memberId, Pageable pageable);

    List<Assignment> findByTitleContaining(String keyword);

    Page<Assignment> findByTitleContaining(String keyword, Pageable pageable);
}
