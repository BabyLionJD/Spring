package com.BabyLion.Spring.service;

import com.BabyLion.Spring.domain.Member;
import com.BabyLion.Spring.domain.RoleType;
import com.BabyLion.Spring.dto.LionCreateRequest;
import com.BabyLion.Spring.dto.LionUpdateRequest;
import com.BabyLion.Spring.dto.StaffCreateRequest;
import com.BabyLion.Spring.dto.StaffUpdateRequest;
import com.BabyLion.Spring.exeption.ErrorCode;
import com.BabyLion.Spring.exeption.InvalidStudentIdException;
import com.BabyLion.Spring.exeption.MemberNotFoundException;
import com.BabyLion.Spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    // 인터페이스에 의존 (구현체에 의존하지 않음)
    private final MemberRepository repository;

    // 생성자를 통해 의존성 주입
    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member createLion(LionCreateRequest dto){
        if (!dto.getStudentId().matches("[0-9]+")){
            throw new InvalidStudentIdException(ErrorCode.INVALID_STUDENT_ID);
        }

        Member member = new Member(
                null,
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.LION,
                dto.getStudentId(),
                null);

        return repository.save(member);
    }

    public Member createStaff(StaffCreateRequest dto){

        Member member = new Member(
                null,
                dto.getName(),
                dto.getMajor(),
                dto.getPart(),
                dto.getGeneration(),
                RoleType.STAFF,
                null,
                dto.getPosition());
        return repository.save(member);
    }


    public Member updateLion(Long id, LionUpdateRequest dto) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
        member.updateInfo(dto.getName(), dto.getMajor(), dto.getPart(), dto.getGeneration());
        member.updateStudentID(dto.getStudentId());
        return repository.save(member);
    }


    public Member updateStaff(Long id, StaffUpdateRequest dto) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
        member.updateInfo(dto.getName(), dto.getMajor(), dto.getPart(), dto.getGeneration());
        member.updatePosition(dto.getPosition());
        return repository.save(member);
    }

    public void deleteMember(Long id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
        repository.delete(member);
    }

    public Member searchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

}
