package com.scalebit.timebadger.model;

public class WorkItem {

    private final SimpleDate date;
    private int startTime = 480; // 08:00
    private int endTime = 1020; // 17:00
    private int breakLength = 60; // 60 minutes
    private Integer adjustedTotalTime = null;
    private String comment = null;

    public WorkItem(SimpleDate simpleDate) {
        this.date = simpleDate;
    }

    public SimpleDate getDate() {
        return date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getBreakLength() {
        return breakLength;
    }

    public void setBreakLength(int breakLength) {
        this.breakLength = breakLength;
    }

    public Integer getAdjustedTotalTime() {
        return adjustedTotalTime;
    }

    public void setAdjustedTotalTime(Integer adjustedTotalTime) {
        this.adjustedTotalTime = adjustedTotalTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getTotalTime() {
        if (this.adjustedTotalTime != null) {
            return this.adjustedTotalTime;
        } else {
            return this.endTime - this.startTime - this.breakLength;
        }

    }
}
