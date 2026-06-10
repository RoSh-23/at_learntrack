package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.EnrollmentInMemoryRepository;
import com.airtribe.learntrack.repository.StudentInMemoryRepository;
import com.airtribe.learntrack.repository.CourseInMemoryRepository;
import com.airtribe.learntrack.enums.EnrollmentStatus;

public class EnrollmentService {

    private final EnrollmentInMemoryRepository enrollmentRepo;

    public EnrollmentService(EnrollmentInMemoryRepository enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    public void addEnrollment(Enrollment enrollment, StudentInMemoryRepository studRepo,
            CourseInMemoryRepository courseRepo) {
        String courseId = enrollment.getCourseId();
        String studentId = enrollment.getStudentId();

        // checking validitiy of course and student Id before adding it in repo
        List<Student> students = studRepo.listAll();
        List<Course> courses = courseRepo.listAll();

        boolean isStudentIdValid = false;
        boolean isCourseIdValid = false;

        for (Student student : students) {
            if (studentId.equals(student.getId())) {
                isStudentIdValid = true;
                break;
            }
        }

        for (Course course : courses) {
            if (courseId.equals(course.getId())) {
                isCourseIdValid = true;
                break;
            }
        }

        if (isCourseIdValid && isStudentIdValid) {
            enrollmentRepo.add(enrollment);
        } else {
            throw new IllegalArgumentException("Provided student or course id is not valid");
        }
    }

    public List<Enrollment> viewAllStudentEnrollments(String studentId) {
        List<Enrollment> allEnrollments = enrollmentRepo.listAll();

        List<Enrollment> resultEnrollments = new ArrayList<>();

        for (Enrollment enrollment : allEnrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
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
