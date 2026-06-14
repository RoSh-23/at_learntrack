package com.airtribe.learntrack.service;

import java.util.List;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseInMemoryRepository;

public class CourseService {

    private final CourseInMemoryRepository courseRepo;

    public CourseService(CourseInMemoryRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void addCourse(Course course) {
        courseRepo.add(course);
    }

    public List<Course> viewAllCourses() {
        return courseRepo.listAll();
    }

    public void activateDeactivateCourse(String id, boolean active) {
        Course course = courseRepo.searchById(id);

        if (course != null) {
            course.setActive(active);
            courseRepo.update(course);
        }
    }
}
