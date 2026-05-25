package com.likelion.likelionspring.domain.role;

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
    public String roleName() {
        return "아기사자";
    }

    @Override
    public String getInfo() {
        return "📌 이름: " + getName() + " | 🎓 전공: " + getMajor() + " | 🔢 기수: " + getGeneration() + " | 💻 파트: " + getPart() + "\n🆔 학번: " + studentId;
    }

    public String getRoleName() {
        return roleName();
    }

    //claude의 도움을 받음
    public void update(String major, int generation, String part, String studentId) {
        updateCommon(major, generation, part);   // 공통 부분은 부모에게
        this.studentId = studentId;               // Lion 고유 부분만 직접
    }
}