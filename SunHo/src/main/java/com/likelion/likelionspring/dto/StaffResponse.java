package com.likelion.likelionspring.dto;

import com.likelion.likelionspring.domain.role.Staff;

public class StaffResponse {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String position;

    public StaffResponse(String name, String major, int generation, String part, String roleName, String position) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.roleName = roleName;
        this.position = position;
    }

    public String getPosition() {return position;}
    public String getRoleName() {return roleName;}
    public String getPart() {return part;}
    public int getGeneration() {return generation;}
    public String getMajor() {return major;}
    public String getName() {return name;}

    public static StaffResponse from(Staff staff){
        return new StaffResponse(
                staff.getName(),
                staff.getMajor(),
                staff.getGeneration(),
                staff.getPart(),
                staff.getRoleName(),
                staff.getPosition()
        );
    }
}
