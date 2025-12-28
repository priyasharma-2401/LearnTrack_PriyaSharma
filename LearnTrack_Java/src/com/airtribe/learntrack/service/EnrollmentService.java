package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnrollmentService {
    private final EnrollmentRepository repository = new EnrollmentRepository();
    private final StudentRepository studentRepository = new StudentRepository();
    private final CourseRepository courseRepository = new CourseRepository();

    public void enrollStudent(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        // Check if student exists and is active

        Student student = studentRepository.findAll().stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        System.out.println(" Student found");
        if (!student.isActive()) {
            System.out.println(" Cannot enroll. Student is inactive.");
            return;
        }

        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        //check if course exists
        Course course = courseRepository.findAll().stream()
                .filter(c -> c.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        repository.save(
                new Enrollment(
                        IdGenerator.getNextEnrollmentId(),
                        studentId,
                        courseId
                )
        );

        System.out.println("Student enrolled successfully");
    }


    public void viewEnrollmentsByStudent(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        Student student = studentRepository.findAll().stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        List<Enrollment> studentEnrollments = repository.findAll().stream()
                .filter(e -> e.getStudentId() == studentId)
                .collect(Collectors.toList());

        if (studentEnrollments.isEmpty()) {
            System.out.println("No enrollment found for Student ID: " + studentId);
            return;
        }
        repository.findAll().stream()
                .filter(e -> e.getStudentId() == studentId)
                .forEach(e -> {
                    Course course = courseRepository.findAll().stream()
                            .filter(c -> c.getId() == e.getCourseId())
                            .findFirst()
                            .orElse(null);

                    if(student.isActive()) {
                        System.out.println(
                                "Enrollments for Student ID   : " + student.getId() +
                                        ", Student Name : " + student.getDisplayName() +
                                        ", Course ID   : " + (course != null ? course.getId() : "N/A") +
                                        ", Course Name : " + (course != null ? course.getCourseName() : "N/A") +
                                        ", Status      : " + e.getStatus()
                        );
                    }
                    else {
                        System.out.println("Sorry student is deactivated");
                    }

                });

    }


    public void updateEnrollmentStatus(Scanner scanner, EnrollmentStatus status) {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        repository.findAll().stream()
                .filter(e -> e.getStudentId() == studentId)
                .forEach(e -> e.setStatus(status));
    }
}
