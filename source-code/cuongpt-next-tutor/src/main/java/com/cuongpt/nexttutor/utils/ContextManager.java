package com.cuongpt.nexttutor.utils;

import org.springframework.stereotype.Component;

@Component
public class ContextManager {

    public String createContext(String level, String skill, String topic, int numberOfQuestions) {
        return String.format(
                "You are an expert English tutor. Create a %s quiz for %s level about %s with %d questions. " +
                        "Return the response in strictly JSON format matching the Question structure: " +
                        "[{ \"id\": \"q1\", \"type\": \"MULTIPLE_CHOICE\", \"content\": \"...\", \"options\": [\"...\"], \"solution\": \"...\", \"explanation\": \"...\", \"hint\": \"...\" }]",
                skill, level, topic, numberOfQuestions);
    }
}
