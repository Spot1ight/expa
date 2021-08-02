package com.automation.expa.domain;

public enum StudentEnum {

    A("Excellent"),
    B("Good"),
    C("Satisfactory");

    private final String description;

    StudentEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
