package com.BabyLion.Spring.repository;

import com.BabyLion.Spring.domain.role.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private List<Role> members = new ArrayList<>();

    @Override
    public <T extends Role> T save(T member) {
        members.add(member);
        return member;
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


    @Override
    public void updateByName(String name, Role newMember) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(name)) {
                members.set(i, newMember);
                return;
            }
        }
    }


    @Override
    public boolean deleteByName(String name) {
        return members.removeIf(member -> member.getName().equals(name));
    }

//    @Override
//    public boolean existsByname(String name) {
//        return false;
//    }
}
