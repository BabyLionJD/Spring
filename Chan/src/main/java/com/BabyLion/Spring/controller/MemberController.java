package com.BabyLion.Spring.controller;

import com.BabyLion.Spring.domain.role.Lion;
import com.BabyLion.Spring.domain.role.Role;
import com.BabyLion.Spring.domain.role.Staff;
import com.BabyLion.Spring.dto.*;
import com.BabyLion.Spring.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Member", description = "멤버 관리 API")
@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @Operation(summary = "Lion 등록", description = "아기사자를 등록합니다.")
    @PostMapping("/lions")
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest dto) {
        try {
            Lion lion = memberService.createLion(dto);
            LionResponse response = LionResponse.from(lion);
            return ResponseEntity.status(201).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @Operation(summary = "Staff 등록", description = "운영진을 등록합니다.")
    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest dto) {
        try {
            Staff staff = memberService.createStaff(dto);
            StaffResponse response = StaffResponse.from(staff);
            return ResponseEntity.status(201).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @Operation(summary = "단일 조회", description = "이름으로 멤버를 조회합니다.")
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role member = memberService.searchByName(name);
        if (member == null) {
            return ResponseEntity.status(404).body("존재하지 않는 이름입니다.");
        }
        if (member instanceof Lion) {
            return ResponseEntity.status(200).body(LionResponse.from((Lion) member));
        } else {
            return ResponseEntity.status(200).body(StaffResponse.from((Staff) member));
        }
    }


    @Operation(summary = "Lion 수정", description = "아기사자 정보를 수정합니다.")
    @PutMapping("/lions/{name}")
    public ResponseEntity<?> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest dto) {
        try {
            Lion lion = memberService.updateLion(name, dto);
            return ResponseEntity.status(200).body(LionResponse.from(lion));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "Staff 수정", description = "운영진 정보를 수정합니다.")
    @PutMapping("/staffs/{name}")
    public ResponseEntity<?> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest dto) {
        try {
            Staff staff = memberService.updateStaff(name, dto);
            return ResponseEntity.status(200).body(StaffResponse.from(staff));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @Operation(summary = "멤버 삭제", description = "이름으로 멤버를 삭제합니다.")
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteMember(@PathVariable String name) {
        try {
            memberService.deleteMember(name);
            return ResponseEntity.status(200).body("삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    //    Lion과 Staff가 섞인 리스트를 instanceof로 분기하여 각각 LionResponse, StaffResponse로 변환한다.(보너스 과제 1)
    @Operation(summary = "전체 조회", description = "모든 멤버를 조회합니다.")
    @GetMapping("/")
    public ResponseEntity<?> getAllMembers(){
        List<Role> members = memberService.getAllMembers();
        List<Object> response = new ArrayList<>();

        for (Role member : members) {
            if (member instanceof Lion) {
                response.add(LionResponse.from((Lion) member));
            } else {
                response.add(StaffResponse.from((Staff) member));
            }
        }
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchMember(@RequestParam String name) {
        Role member = memberService.searchByName(name);
        if (member == null) {
            return ResponseEntity.status(404).body("존재하지 않는 이름입니다.");
        }
        if (member instanceof Lion) {
            return ResponseEntity.status(200).body(LionResponse.from((Lion) member));
        } else {
            return ResponseEntity.status(200).body(StaffResponse.from((Staff) member));
        }
    }
}

