package com.BabyLion.Spring.repository;

import com.BabyLion.Spring.domain.role.Role;

import java.util.List;

public interface MemberRepository {
    <T extends Role> T save(T member);
    Role findByName(String name);
    List<Role> findAll();
    boolean existsByName(String name);

    void updateByName(String name, Role newMember);

    boolean deleteByName(String name);
}
