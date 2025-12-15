# Training Management System (Java Console Application)

## 📌 Overview

The **Training Management System** is a Java console-based application built as a **case study** to demonstrate core Java fundamentals and object-oriented programming concepts.
The system manages **courses, students, trainers, modules, sessions, enrollments, grades, and schedules** using appropriate Java collections and clean layered design.

This project is intentionally designed to focus on **concept clarity, structure, and correctness**, rather than UI complexity.

---

## 🎯 Objectives

* Register **students** and **trainers**
* Create and manage **online and in-person courses**
* Add **modules** and **sessions** to courses
* Enroll students with **capacity and duplicate checks**
* Record and validate **grades**
* Display **sorted student rosters** and **course schedules**
* Handle errors using **custom exceptions** gracefully

---

## 🧱 Core Java Concepts Demonstrated

### ✅ OOP Principles

* **Inheritance**:

  * `Person → Student, Trainer`
  * `Course → OnlineCourse, InPersonCourse`
* **Abstraction**: `Course` is an abstract class
* **Encapsulation**: All fields are private with getters/setters
* **Polymorphism**: Course handling via base `Course` reference

### ✅ Interfaces

* `Identifiable` → entities with an ID
* `Nameable` → entities with name/title

### ✅ Enums

* `EnrollmentStatus` → `ENROLLED`, `COMPLETED`, `DROPPED`

### ✅ Custom Exceptions

* `CourseNotFoundException`
* `StudentNotFoundException`
* `CapacityExceededException`
* `DuplicateEnrollmentException`
* `InvalidGradeException`

Exceptions are **handled gracefully** in the `Main` class to avoid application crashes.

---

## 📦 Package Structure

```
src/
 └── com.tms
     ├── main
     │    └── Main.java
     ├── service
     │    └── TrainingManagementService.java
     ├── model
     │    ├── person
     │    │    ├── Person.java
     │    │    ├── Student.java
     │    │    └── Trainer.java
     │    ├── course
     │    │    ├── Course.java
     │    │    ├── OnlineCourse.java
     │    │    ├── InPersonCourse.java
     │    │    └── Session.java
     │    ├── common
     │    │    └── CourseModule.java
     │    └── enrollment
     │         ├── Enrollment.java
     │         ├── EnrollmentId.java
     │         └── EnrollmentStatus.java
     ├── interfaces
     │    ├── Identifiable.java
     │    └── Nameable.java
     └── exceptions
          ├── CourseNotFoundException.java
          ├── StudentNotFoundException.java
          ├── CapacityExceededException.java
          ├── DuplicateEnrollmentException.java
          └── InvalidGradeException.java
```

---

## 🧮 Collections Used

| Requirement       | Java Collection                   |
| ----------------- | --------------------------------- |
| Course catalog    | `Map<String, Course>`             |
| Students          | `Map<Long, Student>`              |
| Trainers          | `Map<Long, Trainer>`              |
| Modules in course | `List<CourseModule>`              |
| Student skills    | `Set<String>`                     |
| Enrollments       | `Set<Enrollment>`                 |
| Sorted roster     | `TreeSet<Student>`                |
| Course schedule   | `TreeMap<LocalDateTime, Session>` |

---

## 🔁 Application Flow

1. **Main Class**

   * Reads user input
   * Displays menu
   * Calls service methods
   * Handles exceptions

2. **Service Layer**

   * Validates business rules
   * Finds students/courses
   * Coordinates enrollment and grading

3. **Course Layer**

   * Enforces capacity
   * Prevents duplicate enrollment
   * Maintains schedule and modules

---

## 🖥️ Console Features

* Add Course (Online / In-Person)
* Register Student
* Add Modules to Course
* Add Sessions with date & time
* Enroll Student in Course
* Record Grade (0–100 validation)
* View Sorted Roster with **Status & Grade**
* View Course Schedule 

---

## 📸 Sample Outputs

All execution screenshots are available in:

```
Code_Execution_Results/
 ├── Application_Output/
 └── Graceful_Exception_Handling/
```

These include:

* Successful operations
* Capacity exceeded
* Invalid grade input
* Duplicate enrollment
* Course / Student not found

---

## ▶️ How to Run

1. Open project in **Eclipse** or any Java IDE
2. Ensure Java 8+ is installed
3. Run:

   ```
   com.tms.main.Main
   ```
4. Use the console menu to test features

---

## 🏁 Conclusion

This project follows **enterprise-style Java structure**, clean separation of concerns, and effective use of **OOP, collections, and exception handling**. It is designed for learning and interview readiness.

---
