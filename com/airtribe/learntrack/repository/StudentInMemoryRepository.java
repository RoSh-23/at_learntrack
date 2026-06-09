package com.airtribe.learntrack.repository;

import java.util.List;
import java.util.ArrayList;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class StudentInMemoryRepository implements Repository<Student, String> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        for(int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equals(student.getId())) {
                students.set(i, student);
                return;
            }
        }

        throw new EntityNotFoundException("Student with the " + student.getId() + " not found.");
    }

    @Override
    public void removeById(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public Student searchById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student with the " + id + " not found.");
    }

    @Override
    public List<Student> listAll() {
        return new ArrayList<>(students);
    }
}
