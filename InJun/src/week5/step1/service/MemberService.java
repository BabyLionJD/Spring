package week5.step1.service;

import week5.step1.repository.MemberRepository;
import week5.step1.role.Role;

import java.util.List;

public class MemberService {

    private MemberRepository repository = new MemberRepository();

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