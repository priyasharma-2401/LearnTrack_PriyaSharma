package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.Scanner;

public class CourseService {
    private final CourseRepository repository = new CourseRepository();

    public void addCourse(Scanner scanner) {
        int id = IdGenerator.getNextCourseId();
        System.out.print("Course Name: ");
        String name = scanner.next();
        System.out.print("Description: ");
        String desc = scanner.next();
        System.out.print("Duration (weeks): ");
        int weeks = scanner.nextInt();

        repository.save(new Course(id, name, desc, weeks));
    }

    public void viewAllCourses() {
        repository.findAll().forEach(c -> System.out.println("Course id: " + c.getId() + "\n Course Name: " + c.getCourseName() + "\n course is about "+ c.getDescription()));
    }

    public void toggleCourseStatus(Scanner scanner) throws EntityNotFoundException {
        System.out.println("Enter Course id: ");
        int id = scanner.nextInt();

        Course course = repository.findAll().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        course.toggleStatus();
    }
}
