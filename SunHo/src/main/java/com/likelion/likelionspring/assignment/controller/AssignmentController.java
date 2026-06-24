package com.likelion.likelionspring.assignment.controller;

import com.likelion.likelionspring.assignment.domain.Assignment;
import com.likelion.likelionspring.assignment.dto.AssignmentCreateRequest;
import com.likelion.likelionspring.assignment.dto.AssignmentResponse;
import com.likelion.likelionspring.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> save(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {

        Assignment assignment = assignmentService.save(memberId, request.getTitle(), request.getDescription());
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new AssignmentResponse(assignment));
    }

    // 멤버별 과제 목록 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMemberId(@PathVariable Long memberId) {
        List<AssignmentResponse> responses = assignmentService.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::new)
                .toList();
        return ResponseEntity.ok(responses);
    }

    // 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new AssignmentResponse(assignment));
    }

    // 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentCreateRequest request) {

        Assignment assignment = assignmentService.update(id, request.getTitle(), request.getDescription());
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new AssignmentResponse(assignment));
    }

    // 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Assignment assignment = assignmentService.findById(id);
        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
