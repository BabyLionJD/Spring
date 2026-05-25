package com.likelion.likelionspring.dto;

import com.likelion.likelionspring.domain.role.Lion;

public class LionResponse {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;

    public LionResponse(String name, String major, int generation, String part, String roleName, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.studentId = studentId;
    }

    public String getStudentId() {return studentId;}
    public String getRoleName() {return roleName;}
    public String getPart() {return part;}
    public int getGeneration() {return generation;}
    public String getMajor() {return major;}
    public String getName() {return name;}

    public static LionResponse from(Lion lion){
        return new LionResponse(
                 lion.getName(),
                 lion.getMajor(),
                 lion.getGeneration(),
                 lion.getPart(),
                 lion.getRoleName(),
                 lion.getStudentId()
        );
    }
}
