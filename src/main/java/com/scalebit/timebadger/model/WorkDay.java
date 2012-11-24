package com.scalebit.timebadger.model;

import java.util.ArrayList;
import java.util.List;

public class WorkDay {

    private final SimpleDate date;
    private final List<WorkItem> workItems;
    private String comment = null;
    private Integer adjustedTotalTime = null;

    public WorkDay(SimpleDate simpleDate) {
        this.date = simpleDate;
        this.workItems = new ArrayList<WorkItem>();
    }

    public Integer getAdjustedTotalTime() {
        return adjustedTotalTime;
    }

    public void setAdjustedTotalTime(Integer adjustedTotalTime) {
        this.adjustedTotalTime = adjustedTotalTime;
    }

    public SimpleDate getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public void addWorkItem(WorkItem workItem) {
        this.workItems.add(workItem);
    }

    public List<WorkItem> getWorkItems() {
        return workItems;
    }

    public int getTotalTime() {
        if (this.adjustedTotalTime != null) {
            return this.adjustedTotalTime;
        } else {
            int totalTime = 0;
            for (WorkItem workItem : this.workItems) {
                totalTime += workItem.getTotalTime();
            }
            return totalTime;
        }
    }
}
