package com.likelion.likelionspring.assignment.service;

import com.likelion.likelionspring.assignment.domain.Assignment;
import com.likelion.likelionspring.domain.Member;
import com.likelion.likelionspring.assignment.repository.AssignmentRepository;
import com.likelion.likelionspring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

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

    // 과제 등록
    @Transactional
    public Assignment save(Long memberId, String title, String description) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        Assignment assignment = new Assignment(title, description, member);
        return assignmentRepository.save(assignment);
    }

    // 멤버별 과제 조회
    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    // 단건 조회
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    // 수정
    @Transactional
    public Assignment update(Long id, String title, String description) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return null;
        }
        assignment.updateInfo(title, description);
        return assignmentRepository.save(assignment);
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        assignmentRepository.deleteById(id);
    }
}

