package week5.step2.repository;

import week5.step2.role.Lion;
import week5.step2.role.Role;
import week5.step2.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {

    private List<Role> members = new ArrayList<>();

    public MockMemberRepository() {
        members.add(new Lion("테스트사자", "컴퓨터공학과", 13, "백엔드", 20250001));
        members.add(new Staff("테스트운영진", "경영학과", 13, "기획", "회장"));
    }

    @Override
    public void save(Role role) {
        // Mock 저장소는 실제 저장하지 않는다.
    }

    @Override
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    @Override
    public List<Role> findAll() {
        return members;
    }

    @Override
    public boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}