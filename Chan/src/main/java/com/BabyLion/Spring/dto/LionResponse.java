package com.BabyLion.Spring.dto;

import com.BabyLion.Spring.domain.role.Lion;

public class LionResponse {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;

    public LionResponse() {}

    public static LionResponse from(Lion lion) {
        LionResponse dto = new LionResponse();
        dto.name = lion.getName();
        dto.major = lion.getMajor();
        dto.generation = lion.getGeneration();
        dto.part = lion.getPart();
        dto.roleName = lion.roleName();
        dto.studentId = lion.getStudentId();
        return dto;
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

    public String getRoleName() {
        return roleName;
    }

    public String getStudentId() {
        return studentId;
    }
}
