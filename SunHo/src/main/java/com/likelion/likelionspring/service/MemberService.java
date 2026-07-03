package com.likelion.likelionspring.service;

import com.likelion.likelionspring.domain.Member;
import com.likelion.likelionspring.domain.RoleType;
import com.likelion.likelionspring.dto.LionCreateRequest;
import com.likelion.likelionspring.dto.LionUpdateRequest;
import com.likelion.likelionspring.dto.StaffCreateRequest;
import com.likelion.likelionspring.dto.StaffUpdateRequest;
import com.likelion.likelionspring.global.exception.DuplicateMemberNameException;
import com.likelion.likelionspring.global.exception.InvalidMemberRequestException;
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

    private void validateMemberRequest(String name, int generation) {
        if (name == null || name.isBlank()) {
            throw new InvalidMemberRequestException("이름은 빈 문자열일 수 없습니다.");
        }
        if (generation <= 0) {
            throw new InvalidMemberRequestException("기수는 1 이상이어야 합니다.");
        }
    }

    // Lion 생성
    @Transactional
    public Member createLion(LionCreateRequest request) {
        validateMemberRequest(request.getName(), request.getGeneration());
        if (memberRepository.findByName(request.getName()) != null) {
            throw new DuplicateMemberNameException("이미 존재하는 멤버 이름입니다: " + request.getName());
        }
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.LION, request.getStudentId(), null
        );
        return memberRepository.save(member);
    }

    // Staff 생성
    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        validateMemberRequest(request.getName(), request.getGeneration());
        if (memberRepository.findByName(request.getName()) != null) {
            throw new DuplicateMemberNameException("이미 존재하는 멤버 이름입니다: " + request.getName());
        }
        Member member = new Member(
                request.getName(), request.getMajor(), request.getGeneration(),
                request.getPart(), RoleType.STAFF, null, request.getPosition()
        );
        return memberRepository.save(member);
    }

    // Lion 수정
    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    // Staff 수정
    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    // 삭제
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다: " + id));
        memberRepository.deleteById(id);
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