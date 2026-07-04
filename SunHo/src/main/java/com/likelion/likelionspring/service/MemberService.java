package com.likelion.likelionspring.service;

import com.likelion.likelionspring.domain.Member;
import com.likelion.likelionspring.dto.LionUpdateRequest;
import com.likelion.likelionspring.dto.StaffUpdateRequest;
import com.likelion.likelionspring.global.exception.ErrorCodeEnum;
import com.likelion.likelionspring.global.exception.ForbiddenException;
import com.likelion.likelionspring.global.exception.MemberNotFoundException;
import com.likelion.likelionspring.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Lion 수정
    @Transactional
    public Member updateLion(Long id, Long currentMemberId, LionUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        validateOwner(member, currentMemberId);
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    // Staff 수정
    @Transactional
    public Member updateStaff(Long id, Long currentMemberId, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        validateOwner(member, currentMemberId);
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    // 삭제
    @Transactional
    public void deleteMember(Long id, Long currentMemberId) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        validateOwner(member, currentMemberId);
        memberRepository.deleteById(id);
    }

    private void validateOwner(Member member, Long currentMemberId) {
        if (!member.getId().equals(currentMemberId)) {
            throw new ForbiddenException(ErrorCodeEnum.FORBIDDEN);
        }
    }

    // 단건 조회
    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
    }

    // 전체 조회 / 파트별 조회 (페이징)
    public Page<Member> findAll(String part, Pageable pageable) {
        if (part != null) {
            return memberRepository.findByPart(part, pageable);
        }
        return memberRepository.findAll(pageable);
    }
}