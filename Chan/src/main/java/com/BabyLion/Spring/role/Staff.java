package com.BabyLion.Spring.role;

import com.BabyLion.Spring.policy.StaffSubmissionPolicy;
import com.BabyLion.Spring.policy.SubmissionPolicy;

public class Staff extends com.BabyLion.Spring.role.Role {
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
}
