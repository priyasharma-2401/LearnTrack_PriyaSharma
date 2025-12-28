package com.airtribe.learntrack;

import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            MenuOptions.printMainMenu();
            try {
                int choice = InputValidator.readInt(scanner);
                // Learning: if we use -> in switch we need not use break. break is used if we use colon : E.g case 1: xyz(); break;
                switch (choice) {
                    case 1 -> studentService.addStudent(scanner);
                    case 2 -> studentService.viewAllStudents();
                    case 3 -> studentService.searchStudentById(scanner);
                    case 4 -> studentService.updateStudent(scanner);
                    case 5 -> studentService.deactivateStudent(scanner);

                    case 6 -> courseService.addCourse(scanner);
                    case 7 -> courseService.viewAllCourses();
                    case 8 -> enrollmentService.enrollStudent(scanner);
                    case 9 -> enrollmentService.viewEnrollmentsByStudent(scanner);
                    case 10 -> enrollmentService.updateEnrollmentStatus(scanner, EnrollmentStatus.COMPLETED);
                    case 11 -> enrollmentService.updateEnrollmentStatus(scanner, EnrollmentStatus.CANCELLED);

                    case 0 -> exit = true;
                    default -> throw new InvalidInputException("Option not found");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting LearnTrack System");
    }
}
