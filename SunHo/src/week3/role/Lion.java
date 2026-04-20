package week3.role;

import week3.policy.LionPolicy;
import week3.policy.Policy;

public class Lion extends Member {
    private int studentId;

    public Lion(String name, String major, int cohort, String part, int studentId) {
        super(name, major, cohort, part);
        this.studentId = studentId;
    }

    @Override
    public boolean isSubmittable() {
        return true;
    }

    @Override
    public Policy getPolicy() {
        return new LionPolicy(); // claude의 도움을 받음
    }

    @Override
    public String getDetails() {
        return "🎭역할: 아기사자\n"
                + "👤이름: " + getName() + " | 🎓전공: " + getMajor()
                + " | 📌기수: " + getCohort() + " | 🖥파트: " + getPart() + "\n"
                + "🆔학번: " + studentId;
    }
}