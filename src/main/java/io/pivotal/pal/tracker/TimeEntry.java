package io.pivotal.pal.tracker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



public class TimeEntry {


    private long timeEntryId;

    private long projectId;
    private long userId;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")



    @JsonProperty(value = "date")
    private LocalDate parse;

   @JsonProperty(value = "hours")
    private int i;

    public TimeEntry() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return timeEntryId == timeEntry.timeEntryId &&
                getProjectId() == timeEntry.getProjectId() &&
                getUserId() == timeEntry.getUserId() &&
                getI() == timeEntry.getI() &&
                Objects.equals(getParse(), timeEntry.getParse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, getProjectId(), getUserId(), getParse(), getI());
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.i = i;


    }

    public TimeEntry(long projectId, long userId, LocalDate parse, int id) {
        //this.timeEntryId =  (long) Math.random();
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.i = id;
    }

    public long getId() {
        return timeEntryId;
    }


    public void setId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getParse() {
        return parse;
    }

    public void setParse(LocalDate parse) {
        this.parse = parse;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getTimeEntryId() {
        return timeEntryId;
    }

    public void setTimeEntryId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }
}
