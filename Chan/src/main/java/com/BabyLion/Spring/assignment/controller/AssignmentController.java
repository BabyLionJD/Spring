package com.BabyLion.Spring.assignment.controller;

import com.BabyLion.Spring.assignment.domain.Assignment;
import com.BabyLion.Spring.assignment.dto.AssignmentCreateRequest;
import com.BabyLion.Spring.assignment.dto.AssignmentResponse;
import com.BabyLion.Spring.assignment.dto.AssignmentUpdateRequest;
import com.BabyLion.Spring.assignment.service.AssignmentService;
import com.BabyLion.Spring.member.domain.Member;
import com.BabyLion.Spring.member.dto.LionCreateRequest;
import com.BabyLion.Spring.member.dto.MemberResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Assignments", description = "과제 관리 API")
@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @Operation(summary = "과제 등록", description = "과제를 등록합니다.")
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<?> createAssignment(@PathVariable Long memberId,@RequestBody AssignmentCreateRequest dto) {
        Assignment assignment = assignmentService.createAssignment(memberId, dto);
        if (assignment == null) {
            return ResponseEntity.status(404).build();
        }
        AssignmentResponse response = AssignmentResponse.from(assignment);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "과제 목록 조회", description = "과제목록를 조회합니다.")
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<?> getAssignmentsByMember(@PathVariable Long memberId) {
        List<Assignment> assignments = assignmentService.memberAssignment(memberId);
        if (assignments == null) {
            return ResponseEntity.status(404).build();
        }
        List<AssignmentResponse> responses = new ArrayList<>();
        for (Assignment a : assignments) {
            responses.add(AssignmentResponse.from(a));
        }
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "과제 단건 조회", description = "과제를 단건 조회합니다.")
    @GetMapping("/assignments/{id}")
    public ResponseEntity<?> getAssignment(@PathVariable Long id) {
        Assignment assignment = assignmentService.searchAssignment(id);
        if (assignment == null) {
            return ResponseEntity.status(404).build();
        }
        AssignmentResponse response = AssignmentResponse.from(assignment);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "과제 수정", description = "과제를 수정합니다.")
    @PutMapping("/assignments/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable Long id, @RequestBody AssignmentUpdateRequest dto) {
        Assignment assignment = assignmentService.updateAssignment(id, dto);
        if (assignment == null) {
            return ResponseEntity.status(404).build();
        }
        AssignmentResponse response = AssignmentResponse.from(assignment);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "과제 삭제", description = "과제를 삭제합니다.")
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<?> deleteAssignment(@PathVariable Long id) {
        try {
            assignmentService.deleteAssignment(id);
            return ResponseEntity.status(204).build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @Operation(summary = "과제 제목 검색", description = "제목에 특정 키워드가 포함된 과제를 검색합니다.")
    @GetMapping("/assignments/search")
    public ResponseEntity<?> searchAssignments(@RequestParam String keyword) {
        List<Assignment> assignments = assignmentService.searchByTitle(keyword);
        List<AssignmentResponse> responses = assignments.stream()
                .map(AssignmentResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }
}

