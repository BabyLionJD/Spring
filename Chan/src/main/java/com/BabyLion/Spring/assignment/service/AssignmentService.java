package com.BabyLion.Spring.assignment.service;

import com.BabyLion.Spring.assignment.domain.Assignment;
import com.BabyLion.Spring.assignment.dto.AssignmentCreateRequest;
import com.BabyLion.Spring.assignment.dto.AssignmentUpdateRequest;
import com.BabyLion.Spring.assignment.repository.AssignmentRepository;
import com.BabyLion.Spring.exeption.ErrorCode;
import com.BabyLion.Spring.exeption.MemberNotFoundException;
import com.BabyLion.Spring.member.domain.Member;
import com.BabyLion.Spring.member.repository.MemberRepository;
import com.BabyLion.Spring.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberService memberService, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment createAssignment(Long memberId, AssignmentCreateRequest dto){
        Member member = memberRepository.findById(memberId).orElse(null);

        if (member == null){
            return null;
        }
        Assignment assignment = new Assignment(dto.getTitle(), dto.getDescription(), member);
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> memberAssignment(Long memberId){
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null){
            return null;
        }
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment searchAssignment(Long id){
        return assignmentRepository.findById(id)
                .orElse(null);
    }

    @Transactional
    public Assignment updateAssignment(Long id,AssignmentUpdateRequest dto){
        Assignment target = assignmentRepository.findById(id).orElse(null);
        if (target == null){
            return null;
        }
        target.updateInfo(dto.getTitle(), dto.getDescription());
        return assignmentRepository.save(target);
    }

    @Transactional
    public void deleteAssignment(Long id){
        assignmentRepository.deleteById(id);
    }

    public List<Assignment> searchByTitle(String keyword) {
        return assignmentRepository.findByTitleContaining(keyword);
    }
}
