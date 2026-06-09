package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.EnrollmentInMemoryRepository;
import com.airtribe.learntrack.enums.EnrollmentStatus;

public class EnrollmentService {

    private final EnrollmentInMemoryRepository enrollmentRepo;

    public EnrollmentService(EnrollmentInMemoryRepository enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollmentRepo.add(enrollment);
    }

    public List<Enrollment> viewAllStudentEnrollments(String studentId) {
        List<Enrollment> allEnrollments = enrollmentRepo.listAll();

        List<Enrollment> resultEnrollments = new ArrayList<>();

        for (Enrollment enrollment : allEnrollments) {
            if (enrollment.getStudentId() == studentId) {
                resultEnrollments.add(enrollment);
            }
        }

        return resultEnrollments;
    }

    public void setEnrollmentStatus(String id, EnrollmentStatus status) {
        Enrollment enrollment = enrollmentRepo.searchById(id);

        if (enrollment != null) {
            enrollment.setStatus(status);
        }
    }
}
