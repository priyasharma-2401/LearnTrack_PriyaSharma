# LearnTrack_PriyaSharma

**### **Why ArrayList was used instead of array****

In the LearnTrack application, ArrayList is used to store Students, Courses, and Enrollments instead of arrays.
Using ArrayList improves flexibility, readability, and maintainability. Arrays have a fixed size, but ArrayList can grow or shrink as data changes.
Arraylist has methods like add(), remove(), get(), and size() make code simpler and cleaner. In a student management system, the number of students or courses is not known beforehand. ArrayList works well with Java Streams, which I used for searching, filtering, and validating entities (e.g., finding active students or enrollments).\



**### **Where you used static members and why?****

I used static members mainly in the IdGenerator utility class and repository classes. 

* In repository classes for creating lists. If the list is not static in repository classes , every time we create a new repository object, a new empty list will be created. 
Hence, if the list is non-static, these services will not see the same data.
Suppose a student is added in one place but another place says “Student not found”. I had faced this issue

* Usage for creating static variables in ID GENERATOR class like studentId ,courseId =, enrollmentId = 1;
Static methods like getNextStudentId() , getNextCourseId() and getNextEnrollmentId()
Static fields are shared across all objects, ensuring no duplicate IDs because Ids must be globally unique across the entire application.Static methods like getNextStudentId() allow ID generation without creating objects.




### ****Where you used inheritance and what you gained from it?****

I used inheritance in student.java that inherited Person.java and hence I didn't have to create new attributes and could reuse attributes of Person class directly into student class. I even created a trainer class that yet again used Person class' attributes. So there is no need to again and again write any code and prevent redundancy in the code. 