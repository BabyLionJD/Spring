package com.likelion.likelionspring.controller;

import com.likelion.likelionspring.domain.Member;
import com.likelion.likelionspring.dto.*;
import com.likelion.likelionspring.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // ===== Lion 등록 =====
    @PostMapping("/lions")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createLion(@RequestBody LionCreateRequest request) {
        Member member = memberService.createLion(request);
        return MemberResponse.from(member);
    }

    // ===== Staff 등록 =====
    @PostMapping("/staffs")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createStaff(@RequestBody StaffCreateRequest request) {
        Member member = memberService.createStaff(request);
        return MemberResponse.from(member);
    }

    // ===== 멤버 단건 조회 =====
    @GetMapping("/{id}")
    public MemberResponse findMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 멤버가 없습니다");
        }
        return MemberResponse.from(member);
    }

    // ===== Lion 수정 =====
    @PutMapping("/lions/{id}")
    public MemberResponse updateLion(@PathVariable Long id,
                                     @RequestBody LionUpdateRequest request) {
        Member member = memberService.updateLion(id, request);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 라이언이 없습니다");
        }
        return MemberResponse.from(member);
    }

    // ===== Staff 수정 =====
    @PutMapping("/staffs/{id}")
    public MemberResponse updateStaff(@PathVariable Long id,
                                      @RequestBody StaffUpdateRequest request) {
        Member member = memberService.updateStaff(id, request);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 운영진이 없습니다");
        }
        return MemberResponse.from(member);
    }

    // ===== 멤버 삭제 =====
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 멤버가 없습니다");
        }
        memberService.deleteMember(id);
    }
}