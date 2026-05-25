package com.likelion.likelionspring.controller;

import com.likelion.likelionspring.dto.*;
import com.likelion.likelionspring.domain.role.Lion;
import com.likelion.likelionspring.domain.role.Role;
import com.likelion.likelionspring.domain.role.Staff;
import com.likelion.likelionspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // ===== Lion 등록 =====
    @PostMapping("/lions")
    @ResponseStatus(HttpStatus.CREATED)   // ⭐ 성공 시 201 Created
    public LionResponse createLion(@RequestBody LionCreateRequest request) {
        LionResponse response = memberService.lionCreateRequest(request);

        if (response == null) {
            // 중복일 때 409 Conflict
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 이름입니다");
        }
        return response;
    }

    // ===== Staff 등록 =====
    @PostMapping("/staffs")
    @ResponseStatus(HttpStatus.CREATED)
    public StaffResponse createStaff(@RequestBody StaffCreateRequest request) {
        StaffResponse response = memberService.staffCreateRequest(request);

        if (response == null) {
            // 중복일 때 409 Conflict
            throw new ResponseStatusException(HttpStatus.CONFLICT, "이미 존재하는 이름입니다");
        }
        return response;
    }

    // ===== 멤버 조회 =====
    @GetMapping("/{name}")
    public ResponseEntity<?> findMember(@PathVariable String name) {
        // 1) 이름으로 찾기
        Role member = memberService.searchByName(name);

        // 2) 없으면 404
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        // 3) 타입에 따라 다른 응답 DTO로 변환
        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        }
        if (member instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff));
        }

        // 4) 알 수 없는 타입 (방어 코드, 보통 도달 안 함)
        return ResponseEntity.internalServerError().build();
    }

    // ===== Lion 수정 =====
    @PutMapping("/lions/{name}")
    public LionResponse updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request) {

        LionResponse response = memberService.updateLion(name, request);

        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 이름의 라이언이 없습니다");
        }

        return response;  // 성공 → 자동으로 200 OK
    }

    // ===== Staff 수정 =====
    @PutMapping("/staffs/{name}")
    public StaffResponse updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request) {

        StaffResponse response = memberService.updateStaff(name, request);

        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 이름의 운영진이 없습니다");
        }

        return response;
    }

    // ===== 멤버 삭제 =====
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);

        if (!deleted) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 이름의 멤버가 없습니다");
        }
        // 성공이면 그냥 끝 → 자동으로 204 No Content
    }
}
