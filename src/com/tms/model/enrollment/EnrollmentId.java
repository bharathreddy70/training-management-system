package com.tms.model.enrollment;

import java.util.Objects;


public class EnrollmentId {

    private final Long studentId;
    private final String courseCode;

    public EnrollmentId(Long studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentId)) return false;
        EnrollmentId that = (EnrollmentId) o;
        return Objects.equals(studentId, that.studentId) &&
               Objects.equals(courseCode, that.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseCode);
    }

    @Override
    public String toString() {
        return studentId + "-" + courseCode;
    }
}
