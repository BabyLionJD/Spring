package week5.step1.repository;

import week5.step1.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Role> members = new ArrayList<>();

    public void save(Role role) {
        members.add(role);
    }

    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    public List<Role> findAll() {
        return members;
    }

    public boolean existsByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}