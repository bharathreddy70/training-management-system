package com.tms.model.person;

import java.util.HashSet;
import java.util.Set;
import com.tms.model.enrollment.Enrollment;

public class Student extends Person {

    private Set<String> skills;
    private Set<String> enrolledCourses;

    // Constructor with just id and name
    public Student(Long id, String name) {
        super(id, name);
        this.skills = new HashSet<>();
        this.enrolledCourses = new HashSet<>();
    }

    // Full constructor if needed
    public Student(Long id, String name, Set<String> skills, Set<String> enrolledCoursess) {
        super(id, name);
        this.skills = skills;
        this.enrolledCourses = enrolledCourses;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Set<String> getenrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrollments(Set<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    // Convenience methods
    public void addSkill(String skill) {
        skills.add(skill);
    }

    public void addEnrolledCourse(String courseCode) {
        enrolledCourses.add(courseCode);
    }
}
