package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class EnrollmentInMemoryRepository implements Repository<Enrollment, String> {
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void add(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public void update(Enrollment enrollment) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getId().equals(enrollment.getId())) {
                enrollments.set(i, enrollment);
                return;
            }
        }

        throw new EntityNotFoundException("Enrollment with the " + enrollment.getId() + " not found.");
    }

    @Override
    public void removeById(String id) {
        enrollments.removeIf(enrollment -> enrollment.getId().equals(id));
    }

    @Override
    public Enrollment searchById(String id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId().equals(id)) {
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment with the " + id + " not found.");
    }

    @Override
    public List<Enrollment> listAll() {
        return new ArrayList<>(enrollments);
    }
}
