package com.BabyLion.Spring.assignment.dto;

import com.BabyLion.Spring.assignment.domain.Assignment;
import com.BabyLion.Spring.member.domain.Member;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Getter
public class AssignmentResponse {
    private Long id;
    private String title;
    private String description;
    private Long memberId;
    private String memberName;

    public AssignmentResponse(Long id, String title, String description, Long memberId, String memberName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public static AssignmentResponse from(Assignment assignment) {
        return new AssignmentResponse(
                assignment.getId(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getMember().getId(),
                assignment.getMember().getName());
    }

    public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
        List<Assignment> findByMemberId(Long memberId);

        @Query("SELECT a FROM Assignment a WHERE a.title LIKE %:keyword%")
        List<Assignment> findByTitleContaining(@Param("keyword") String keyword);
    }
}
