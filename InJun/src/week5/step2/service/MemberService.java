package week5.step2.service;

import week5.step2.repository.MemberRepository;
import week5.step2.role.Role;

import java.util.List;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean register(Role role) {
        if (repository.existsByName(role.getName())) {
            return false;
        }

        repository.save(role);
        return true;
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> findAll() {
        return repository.findAll();
    }
}