package com.BabyLion.Spring.service;

import com.BabyLion.Spring.domain.role.Lion;
import com.BabyLion.Spring.domain.role.Role;
import com.BabyLion.Spring.domain.role.Staff;
import com.BabyLion.Spring.dto.LionCreateRequest;
import com.BabyLion.Spring.dto.LionUpdateRequest;
import com.BabyLion.Spring.dto.StaffCreateRequest;
import com.BabyLion.Spring.dto.StaffUpdateRequest;
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

    public Lion createLion(LionCreateRequest dto){

        if (repository.existsByName(dto.getName())){
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }

        Lion lion = new Lion(dto.getName(), dto.getMajor(), dto.getGeneration(), dto.getPart(), dto.getStudentId());
        return repository.save(lion);
    }

    public Staff createStaff(StaffCreateRequest dto){
        if (repository.existsByName(dto.getName())){
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }

        Staff staff = new Staff(dto.getName(), dto.getMajor(), dto.getGeneration(), dto.getPart(), dto.getPosition());
        return repository.save(staff);
    }


    public Lion updateLion(String name, LionUpdateRequest dto) {
        Lion lion = (Lion) repository.findByName(name);
        if (lion == null) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        lion.update(dto.getMajor(), dto.getGeneration(), dto.getPart(), dto.getStudentId());
        repository.updateByName(name, lion);
        return lion;
    }


    public Staff updateStaff(String name, StaffUpdateRequest dto) {
        Staff staff = (Staff) repository.findByName(name);
        if (staff == null) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        staff.update(dto.getMajor(), dto.getGeneration(), dto.getPart(), dto.getPosition());
        repository.updateByName(name, staff);
        return staff;
    }

    public void deleteMember(String name) {
        if (!repository.existsByName(name)) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        repository.deleteByName(name);
    }


}
