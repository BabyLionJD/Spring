package com.BabyLion.Spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LionCreateRequest {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;
}
