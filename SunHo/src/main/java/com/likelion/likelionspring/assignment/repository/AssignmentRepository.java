package com.likelion.likelionspring.assignment.repository;

import com.likelion.likelionspring.assignment.domain.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByMemberId(Long memberId);

    @Query("SELECT a FROM Assignment a WHERE a.title LIKE %:title%")
    List<Assignment> findByTitleContainingJPQL(@Param("title") String title);

    List<Assignment> findByTitleContaining(String keyword);
}
