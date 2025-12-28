package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentId = 1;
    private static int courseId = 1;
    private static int enrollmentId = 1;

    public static int getNextStudentId() { return studentId++; }
    public static int getNextCourseId() { return courseId++; }
    public static int getNextEnrollmentId() { return enrollmentId++; }
}
