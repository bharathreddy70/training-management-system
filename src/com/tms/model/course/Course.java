package com.tms.model.course;

import java.time.LocalDateTime;
import java.util.*;

import com.tms.exceptions.CapacityExceededException;
import com.tms.exceptions.DuplicateEnrollmentException;
import com.tms.interfaces.Identifiable;
import com.tms.interfaces.Nameable;
import com.tms.model.common.CourseModule;
import com.tms.model.enrollment.Enrollment;
import com.tms.model.person.Student;
import com.tms.model.person.Trainer;

public abstract class Course implements Identifiable<String>, Nameable {

    private final String courseCode;   // Immutable ID
    private String title;
    private Integer capacity;
    private Trainer trainer;

    // Collections
    private final List<CourseModule> modules = new ArrayList<>();
    private final TreeMap<LocalDateTime, Session> schedule = new TreeMap<>();
    private final Set<Enrollment> enrollments = new HashSet<>();

    protected Course(String courseCode, String title, Integer capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
    }

    // -------------------- Identifiable & Nameable --------------------

    @Override
    public String getId() {
        return courseCode;
    }

    @Override
    public String getName() {
        return title;
    }

    // -------------------- Getters / Setters --------------------

    public void assignTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public List<CourseModule> getModules() {
        return modules;
    }
    public TreeMap<LocalDateTime, Session> getSchedule() {
        return schedule;
    }
    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    // -------------------- Behavior Methods --------------------

    // Add module to course
    public void addModule(CourseModule module) {
        modules.add(module);
    }

    // Add session to schedule (auto-sorted by date)
    public void addSession(Session session) {
        schedule.put(session.getDateTime(), session);
    }

    // Enroll student with validation
    public void enrollStudent(Enrollment enrollment) {
        if (enrollments.size() >= capacity) {
            throw new CapacityExceededException();
        }
        if (!enrollments.add(enrollment)) {
            throw new DuplicateEnrollmentException();
        }
        enrollments.add(enrollment);
    }

    // Check if a student is already enrolled
    public boolean isStudentEnrolled(Long studentId) {
        return enrollments.stream()
                .anyMatch(e -> e.getStudentId().equals(studentId));
    }

    // Sorted roster using TreeSet + custom comparator
    public Set<Student> getSortedRoster(Map<Long, Student> studentMap) {

        Set<Student> roster = new TreeSet<>(
                Comparator.comparing(Student::getName)
                          .thenComparing(Student::getId)
        );

        for (Enrollment enrollment : enrollments) {
            Student student = studentMap.get(enrollment.getStudentId());
            if (student != null) {
                roster.add(student);
            }
        }
        return roster;
    }
}
