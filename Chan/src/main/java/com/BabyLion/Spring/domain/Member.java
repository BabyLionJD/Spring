package com.BabyLion.Spring.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 내부에서만 쓰도록 protected
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name, major, part;
    int generation;
    @Enumerated(EnumType.STRING)
    RoleType roleType;
    String studentId;
    String position;

    //id는 자동 생성하므로 생성자에서 제외(GenerateValue)
    public Member(String name, String major, String part, int generation, RoleType roleType, String studentId, String position) {
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
        this.roleType = roleType;
        this.studentId = studentId;
        this.position = position;
    }

//    protected Member() {}
//    JPA가 DB에서 데이터를 꺼낼 때 빈 객체를 먼저 만들고 값을 채우는 방식을 사용하므로 필요 (롬복 어노테이션으로 대체)

    public void updateInfo(String name, String major, String part, int generation){
        this.name = name;
        this.major = major;
        this.part = part;
        this.generation = generation;
    }

    public void updateStudentID(String studentId){
        this.studentId = studentId;
    }

    public void updatePosition(String position){
        this.position = position;
    }
}
