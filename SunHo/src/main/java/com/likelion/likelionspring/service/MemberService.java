package com.likelion.likelionspring.service;

import com.likelion.likelionspring.dto.*;
import com.likelion.likelionspring.repository.MemberRepository;
import com.likelion.likelionspring.domain.role.Lion;
import com.likelion.likelionspring.domain.role.Role;
import com.likelion.likelionspring.domain.role.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 멤버 관련 비즈니스 로직을 처리하는 역할 (서비스)
 *
 * [개선됨] 의존성 주입(DI) 적용
 * - Repository를 직접 생성하지 않고, 생성자를 통해 외부에서 주입받는다
 * - Repository 인터페이스에만 의존하므로 구현체가 바뀌어도 이 코드는 수정 불필요
 * - final 키워드로 불변성 보장
 */

@Service
public class MemberService {
    // 인터페이스에 의존 (구현체에 의존하지 않음)
    private final MemberRepository repository;

    @Autowired
    // 생성자를 통해 의존성 주입
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role member) {
        if (repository.existsByName(member.getName())) {
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }

    public boolean isEmpty() {
        return repository.findAll().isEmpty();
    }

    // ===== 생성 =====
    public LionResponse lionCreateRequest(LionCreateRequest request){
        // 이름 중복 검사 로직
        if (repository.existsByName(request.getName())){
            return null;
        }

        // Lion 객체 생성 및 초기화
        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        // Lion 객체 저장
        repository.save(lion);

        // 반환
        return LionResponse.from(lion);
    }

    public StaffResponse staffCreateRequest(StaffCreateRequest request) {
        if (repository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        repository.save(staff);
        return StaffResponse.from(staff);
    }

    public LionResponse updateLion(String name, LionUpdateRequest request) {
        // 이름으로 찾기
        Role member = repository.findByName(name);
        if (member == null) {
            return null;
        }

        // Lion인지 확인 + 캐스팅
        if (!(member instanceof Lion lion)) {
            return null;
        }

        // 변경
        lion.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        return LionResponse.from(lion);
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest request) {
        Role member = repository.findByName(name);
        if (member == null) {
            return null;
        }

        // Staff인지 확인 + 캐스팅
        if (!(member instanceof Staff staff)) {
            return null;
        }

        staff.update(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        return StaffResponse.from(staff);
    }

    // ===== 삭제 =====
    public boolean deleteMember(String name) {
        if (!repository.existsByName(name)) {
            return false;
        }
        repository.existsByName(name);
        return true;
    }
}
