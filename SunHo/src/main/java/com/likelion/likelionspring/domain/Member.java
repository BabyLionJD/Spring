package com.likelion.likelionspring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private int generation;
    private String part;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String studentId;  // Lion일 때만 값 존재, Staff는 null
    private String position;   // Staff일 때만 값 존재, Lion은 null

    // JPA 기본 생성자 (필수)
    protected Member() {
    }

    // 전체 필드 생성자 (id는 자동 생성이라 제외)
    public Member(String name, String major, int generation, String part,
                  RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

    // 공통 정보 수정
    public void updateInfo(String major, int generation, String part) {
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // Lion 학번 수정
    public void updateStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Staff 직책 수정
    public void updatePosition(String position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPosition() {
        return position;
    }
}
