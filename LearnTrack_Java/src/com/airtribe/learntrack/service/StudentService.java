package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.Scanner;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public void addStudent(Scanner scanner) {
        int id = IdGenerator.getNextStudentId();
        System.out.print("First Name: ");
        String fn = scanner.next();
        System.out.print("Last Name: ");
        String ln = scanner.next();
        System.out.print("Batch: ");
        String batch = scanner.next();

        repository.save(new Student(id, fn, ln, batch));
        System.out.println("Student Added");
    }

    public void viewAllStudents() {
        repository.findAll().stream()
                .filter(Student::isActive)
                .forEach(s ->
                        System.out.println("Id: " + s.getId() +
                                " Name: " + s.getDisplayName())
                );

    }

    public void searchStudentById(Scanner scanner) throws EntityNotFoundException {
        System.out.println("Enter Student ID:");
        int id = scanner.nextInt();
        Student student = repository.findAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        System.out.println("ID   : " + student.getId());
        System.out.println(student.getDisplayName());
    }
    public void updateStudent(Scanner scanner) throws EntityNotFoundException {
        System.out.print("Enter Student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        // Find the student
        Student student = repository.findAll().stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        // Check if student is active
        if (!student.isActive()) {
            System.out.println("Cannot update. Student is inactive.");
            return;
        }

        // Prompt for new details
        System.out.print("Enter new first name (current: " + student.getFirstName() + "): ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new last name (current: " + student.getLastName() + "): ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new email (current: " + student.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter new batch (current: " + student.getBatch() + "): ");
        String batch = scanner.nextLine();

        // Update student
        student.setFirstName(firstName.isEmpty() ? student.getFirstName() : firstName);
        student.setLastName(lastName.isEmpty() ? student.getLastName() : lastName);
        student.setEmail(email.isEmpty() ? student.getEmail() : email);
        student.setBatch(batch.isEmpty() ? student.getBatch() : batch);

        System.out.println("Student updated successfully!");
    }

    public void deactivateStudent(Scanner scanner) throws EntityNotFoundException {
        int id = scanner.nextInt();
        Student student = repository.findAll().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        student.deactivate();
    }
}
