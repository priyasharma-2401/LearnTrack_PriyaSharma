package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }
}
