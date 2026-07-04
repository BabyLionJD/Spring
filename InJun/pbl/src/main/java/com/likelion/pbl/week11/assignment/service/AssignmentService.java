package com.likelion.pbl.week11.assignment.service;

import com.likelion.pbl.week11.assignment.domain.Assignment;
import com.likelion.pbl.week11.assignment.dto.AssignmentCreateRequest;
import com.likelion.pbl.week11.assignment.dto.AssignmentUpdateRequest;
import com.likelion.pbl.week11.assignment.repository.AssignmentRepository;
import com.likelion.pbl.week11.domain.Member;
import com.likelion.pbl.week11.global.exception.*;
import com.likelion.pbl.week11.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = getMember(memberId);
        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public Page<Assignment> findAll(Pageable pageable) {
        return assignmentRepository.findAll(pageable);
    }

    public List<Assignment> findByMemberId(Long memberId) {
        getMember(memberId);
        return assignmentRepository.findByMemberId(memberId);
    }

    public Page<Assignment> findByMemberId(Long memberId, Pageable pageable) {
        getMember(memberId);
        return assignmentRepository.findByMemberId(memberId, pageable);
    }

    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }

    public Page<Assignment> searchByTitle(String keyword, Pageable pageable) {
        return assignmentRepository.findByTitleContaining(keyword, pageable);
    }

    public Assignment findById(Long id) {
        return getAssignment(id);
    }

    @Transactional
    public Assignment updateAssignment(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = getAssignment(id);
        validateOwner(assignment);
        assignment.updateInfo(request.getTitle(), request.getDescription());
        return assignment;
    }

    @Transactional
    public void deleteAssignment(Long id) {
        Assignment assignment = getAssignment(id);
        validateOwner(assignment);
        assignmentRepository.delete(assignment);
    }

    private Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + memberId));
    }

    private Assignment getAssignment(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("해당 과제를 찾을 수 없습니다. id: " + id));
    }

    private void validateOwner(Assignment assignment) {
        Long currentMemberId = getCurrentMemberId();
        Long ownerId = assignment.getMember().getId();
        if (!ownerId.equals(currentMemberId)) {
            throw new ForbiddenException(ErrorCodeEnum.FORBIDDEN);
        }
    }

    private Long getCurrentMemberId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            throw new AuthenticationFailedException("인증 정보가 없습니다.");
        }

        Object principal = authentication.getPrincipal();

        if (!(principal instanceof Long memberId)) {
            throw new AuthenticationFailedException("유효하지 않은 인증 정보입니다.");
        }

        return memberId;
    }
}
