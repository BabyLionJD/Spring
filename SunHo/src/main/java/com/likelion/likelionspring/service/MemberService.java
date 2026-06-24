package com.likelion.likelionspring.service;

import com.likelion.likelionspring.domain.Member;
import com.likelion.likelionspring.domain.RoleType;
import com.likelion.likelionspring.dto.LionCreateRequest;
import com.likelion.likelionspring.dto.LionUpdateRequest;
import com.likelion.likelionspring.dto.StaffCreateRequest;
import com.likelion.likelionspring.dto.StaffUpdateRequest;
import com.likelion.likelionspring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Lion 생성
    @Transactional
    public Member createLion(LionCreateRequest request) {
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.LION, request.getStudentId(), null
        );
        return memberRepository.save(member);
    }

    // Staff 생성
    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.STAFF, null, request.getPosition()
        );
        return memberRepository.save(member);
    }

    // Lion 수정
    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    // Staff 수정
    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    // 삭제
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // 단건 조회
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}