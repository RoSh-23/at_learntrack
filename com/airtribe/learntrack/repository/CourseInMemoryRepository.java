package com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseInMemoryRepository implements Repository<Course, String> {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public void update(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId().equals(course.getId())) {
                courses.set(i, course);
                return;
            }
        }

        throw new EntityNotFoundException("Course with the " + course.getId() + " not found.");
    }

    @Override
    public void removeById(String id) {
        courses.removeIf(course -> course.getId().equals(id));
    }

    @Override
    public Course searchById(String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with the " + id + " not found.");
    }

    @Override
    public List<Course> listAll() {
        return new ArrayList<>(courses);
    }
}
