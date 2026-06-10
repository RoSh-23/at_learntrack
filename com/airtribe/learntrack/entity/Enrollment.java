package com.airtribe.learntrack.entity;

import java.time.LocalDate;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.util.InputValidators;
import com.airtribe.learntrack.util.IdGenerator;

public class Enrollment {
    private final String id;
    private String studentId;
    private String courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(String studentId, String courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        InputValidators.isValidEnrollmentDate(enrollmentDate);

        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Enrollment(String studentId, String courseId) {
        this.enrollmentDate = LocalDate.now();
        InputValidators.isValidEnrollmentDate(enrollmentDate);

        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = EnrollmentStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        InputValidators.isValidEnrollmentDate(enrollmentDate);
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "| Student ID: %-5s | Course ID: %-5s | Enrollment Date: %-10tF | Status: %-2B |",
                this.getId(), this.getStudentId(), this.getCourseId(), this.getEnrollmentDate(), this.getStatus());
    }
}
