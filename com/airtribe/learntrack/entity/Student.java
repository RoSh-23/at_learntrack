package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.InputValidators;
import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person {
    private final String id;
    private Integer batch;
    private boolean active;

    public Student(String firstName, String lastName, String email, Integer batch, boolean active) {
        super(firstName, lastName, email);
        InputValidators.isValidStudentBatch(batch);

        this.id = IdGenerator.getNextStudentId();
        this.batch = batch;
        this.active = active;
    }

    public Student(String firstName, String lastName, String email, Integer batch) {
        this(firstName, lastName, email, batch, true);
    }

    public String getId() {
        return id;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        InputValidators.isValidStudentBatch(batch);
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format(
                "| ID: %-5s | First Name: %-10s | Last Name: %-10s | Email: %-10s | Batch: %-3d | Status: %-2B |",
                this.getId(), this.getFirstName(), this.getLastName(), this.getEmail(), this.getBatch(),
                this.isActive());
    }
}
