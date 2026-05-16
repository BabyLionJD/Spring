package com.BabyLion.Spring.dto;

import com.BabyLion.Spring.domain.role.Staff;

public class StaffResponse {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String position;

    public static StaffResponse from(Staff staff) {
        StaffResponse dto = new StaffResponse();
        dto.name = staff.getName();
        dto.major = staff.getMajor();
        dto.generation = staff.getGeneration();
        dto.part = staff.getPart();
        dto.roleName = staff.roleName();
        dto.position = staff.getPosition();
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

    public String getPosition() {
        return position;
    }
}
