# LearnTrack_PriyaSharma
LearnTrack is a console-based Student & Course Management System built using Core Java. 
It will allow admins to manage: Students ,Courses ,Enrollments

## Features

### Student Management
- Add new students
- View all students
- Update student details
- Search student by ID
- Deactivate a student (without deleting)

### Course Management
- Add new courses
- View all courses

### Enrollment Management
- Enroll a student in a course
- View enrollments for a student
- Mark enrollment as completed or cancelled



### Class Diagram 

#### **Main Classes** 

Person (Base class)

   Attributes: id, firstName, lastName, email

   Methods: getDisplayName()

Student (extends Person)

   Attributes: batch, active

   Methods: getDisplayName(), getters/setters

Course

   Attributes: id, courseName, description, durationInWeeks, active

   Methods: getters/setters

Enrollment

   Attributes: id, studentId, courseId, enrollmentDate, status

   Methods: getters/setters


### **Repositories (in-memory storage)**

* StudentRepository → stores List<Student>
* CourseRepository → stores List<Course>
* EnrollmentRepository → stores List<Enrollment>


### **Services (business logic)**

StudentService, CourseService, EnrollmentService

### **Utilities**

IdGenerator → static counters for unique IDs

### **Exceptions**

EntityNotFoundException, InvalidInputException

####  **Relationships**

#### Inheritance

   Student → inherits Person

#### Association

   Enrollment → links Student and Course via studentId and courseId

#### Dependency

   Services use Repositories (StudentService → StudentRepository, etc.)
   Main.java depends on Services to execute menu operations.

