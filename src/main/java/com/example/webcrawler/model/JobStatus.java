package com.example.webcrawler.model;

public enum JobStatus {
    NOT_STARTED(0), ACTIVE(1), SUCCESSFUL(2), ERROR(3);
    private final Integer value;
    private JobStatus(int value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
