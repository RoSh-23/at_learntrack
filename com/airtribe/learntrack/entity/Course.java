package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidators;

public class Course {
    private final String id;
    private String courseName;
    private String description;
    private Integer durationInWeeks;
    private boolean active;

    public Course(String courseName, String description, Integer durationInWeeks, boolean active) {
        InputValidators.isValidCourseName(courseName);
        InputValidators.isValidCourseDescription(description);
        InputValidators.isValidCourseDuration(durationInWeeks);

        this.id = IdGenerator.getNextCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public Course(String courseName, String description, Integer durationInWeeks) {
        InputValidators.isValidCourseName(courseName);
        InputValidators.isValidCourseDescription(description);
        InputValidators.isValidCourseDuration(durationInWeeks);

        this.id = IdGenerator.getNextCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = true;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        InputValidators.isValidCourseName(courseName);
        this.courseName = courseName;
    }

    public Integer getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(Integer durationInWeeks) {
        InputValidators.isValidCourseDuration(durationInWeeks);
        this.durationInWeeks = durationInWeeks;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format(
                "| ID: %-5s | Course Name: %-10s | Duration in Weeks: %-10d  | Status: %-2B |",
                this.getId(), this.getCourseName(), this.getDurationInWeeks(), this.getActive());
    }
}
