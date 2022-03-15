package com.bol.kalah.util;

public enum LogStatus {
    START("Start"),
    END("End"),
    Exception("Exception");

    private String status;

    LogStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}