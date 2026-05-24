package com.BabyLion.Spring.domain.role;

import com.BabyLion.Spring.dto.LionUpdateRequest;
import com.BabyLion.Spring.policy.StaffSubmissionPolicy;
import com.BabyLion.Spring.policy.SubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public SubmissionPolicy submissionPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String roleName() {
        return "운영진";
    }

    @Override
    public String getInfo() {
        return "📌 이름: " + getName() + " | 🎓 전공: " + getMajor() + " | 🔢 기수: " + getGeneration() + " | 💻 파트: " + getPart() + "\n⭐ 직책: " + position;
    }

    public void update(String major, int generation, String part, String position) {
        setMajor(major);
        setGeneration(generation);
        setPart(part);
        this.position = position;
    }

}
