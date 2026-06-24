package com.likelion.likelionspring.assignment.dto;

public class AssignmentUpdateRequest {

    private String title;
    private String description;

    public AssignmentUpdateRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
