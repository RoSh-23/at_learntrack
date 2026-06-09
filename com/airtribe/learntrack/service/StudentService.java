package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.StudentInMemoryRepository;
import java.util.List;
import com.airtribe.learntrack.entity.Student;

public class StudentService {

    private final StudentInMemoryRepository studentRepo;

    public StudentService(StudentInMemoryRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        studentRepo.add(student);
    }

    public List<Student> viewAllStudents() {
        return studentRepo.listAll();
    }

    public Student searchStudentById(String id) {
        return studentRepo.searchById(id);
    }

    public void deactivateStudent(String id) {
        Student student = studentRepo.searchById(id);

        if (student != null) {
            student.setActive(false);
            studentRepo.update(student);
        }
    }
}
