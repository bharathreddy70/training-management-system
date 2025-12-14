package com.tms.model.enrollment;

import java.util.Objects;

import com.tms.exceptions.InvalidGradeException;
import com.tms.interfaces.Identifiable;


public class Enrollment implements Identifiable<EnrollmentId> {

    private Long studentId;
    private String courseCode;
    private EnrollmentStatus status;
    private Integer grade;

    public Enrollment(Long studentId, String courseCode, EnrollmentStatus status) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.status = status;
    }

    public Enrollment(Long studentId, String courseCode,
                      EnrollmentStatus status, Integer grade) {
        this(studentId, courseCode, status);
        setGrade(grade);
    }

    /**
     * Identity of Enrollment = (studentId + courseCode)
     */
    @Override
    public EnrollmentId getId() {
        return new EnrollmentId(studentId, courseCode);
    }

    // ---------------- equals & hashCode ----------------
    // Must match identity definition

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment)) return false;
        Enrollment other = (Enrollment) o;
        return Objects.equals(studentId, other.studentId) &&
               Objects.equals(courseCode, other.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseCode);
    }

    // ---------------- Getters & Setters ----------------

    public Long getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        if (grade != null && (grade < 0 || grade > 100)) {
            throw new InvalidGradeException("Grade must be between 0 and 100.");
        }
        this.grade = grade;
    }
}
