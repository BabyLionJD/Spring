package com.BabyLion.Spring.domain.role;

import com.BabyLion.Spring.policy.LionSubmissionPolicy;
import com.BabyLion.Spring.policy.SubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public SubmissionPolicy submissionPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String roleName() {
        return "아기사자";
    }

    @Override
    public String getInfo() {
        return "📌 이름: " + getName() + " | 🎓 전공: " + getMajor() + " | 🔢 기수: " + getGeneration() + " | 💻 파트: " + getPart() + "\n🆔 학번: " + studentId;
    }

    public void update(String major, int generation, String part, String studentId) {
        setMajor(major);
        setGeneration(generation);
        setPart(part);
        this.studentId = studentId;
    }
}
