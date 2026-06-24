package com.likelion.likelionspring.assignment.dto;

import com.likelion.likelionspring.assignment.domain.Assignment;
import com.likelion.likelionspring.domain.Member;

public class AssignmentResponse {

    private String id;
    private String title;
    private String description;
    private String memberId;
    private String memberName;

    public AssignmentResponse(String id, String title, String description, String memberId, String memberName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public AssignmentResponse(Assignment assignment) {
        this.id = String.valueOf(assignment.getId());
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();
        this.memberId = String.valueOf(assignment.getMember().getId());
        this.memberName = assignment.getMember().getName();
    }

    public static AssignmentResponse from(Assignment assignment){
        Member member = assignment.getMember();

        return new AssignmentResponse(
                String.valueOf(assignment.getId()),
                assignment.getTitle(),
                assignment.getDescription(),
                String.valueOf(assignment.getMember().getId()),
                assignment.getMember().getName()
        );
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getMemberId() { return memberId; }
    public String getMemberName() { return memberName; }
}

