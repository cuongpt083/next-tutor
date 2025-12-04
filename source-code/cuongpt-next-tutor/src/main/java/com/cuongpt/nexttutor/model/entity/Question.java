package com.cuongpt.nexttutor.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String id;
    private String type;
    private String content;
    private List<String> options;
    private String solution;
    private String explanation;
    private String hint;
    private String audioUrl;
}
