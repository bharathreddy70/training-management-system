package com.tms.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tms.exceptions.CourseNotFoundException;
import com.tms.exceptions.StudentNotFoundException;
import com.tms.model.course.Course;
import com.tms.model.enrollment.Enrollment;
import com.tms.model.enrollment.EnrollmentStatus;
import com.tms.model.person.Student;
import com.tms.model.person.Trainer;

public class TrainingManagementService {
 private Map<String,Course> courses=new HashMap<String, Course>();
 private Map<Long, Student> students=new HashMap<Long, Student>();
 private Map<Long, Trainer> trainers= new HashMap<Long, Trainer>();


 public void addCourse(Course course) {
	 courses.put(course.getId(), course);
 }
 public void registerStudent(Student student) {
	 students.put(student.getId(),student);
 }
 public void registerTrainers(Trainer trainer) {
	 trainers.put(trainer.getId(), trainer);
 }
 
 public Course findCourse(String courseCode) {
	 Course course = courses.get(courseCode);
	 if(course==null) {
		 throw new CourseNotFoundException("Course with course code: "+courseCode+" is not available!");
	 }
	 return course;
 }
 public Student findStudent(Long studentId) {
	 Student student= students.get(studentId);
	 if(student==null) {
		 throw new StudentNotFoundException("Student with Id: "+studentId+" is not available!");
	 }
	 return student;
 }

 public void registerTrainer(Trainer trainer) {
     if (trainers.containsKey(trainer.getId())) {
         throw new IllegalArgumentException("Trainer already exists");
     }
     trainers.put(trainer.getId(), trainer);
 }

 public Trainer findTrainer(Long id) {
     Trainer trainer = trainers.get(id);
     if (trainer == null) {
         throw new IllegalArgumentException("Trainer not found");
     }
     return trainer;
 }

 public void enrollStudent(Long StudentId,String courseCode) {
	 Course course = findCourse(courseCode);
	 Student student = findStudent(StudentId);
	 
	 Enrollment enrollment=new Enrollment(
			 StudentId,
             courseCode,
             EnrollmentStatus.ENROLLED,
             null
             );
	 course.enrollStudent(enrollment);
	 student.addEnrolledCourse(courseCode);
	 
 }
 
 public void recordGrade(Long studentId,String courseCode,Integer grade) {
	 
	Course course = findCourse(courseCode);
	Enrollment enrollment= course.getEnrollments()
			            .stream()
			            .filter(e->e.getStudentId().equals(studentId))
			            .findFirst()
			            .orElseThrow(()-> new StudentNotFoundException("Student Not Found!!"));
	                     
	 enrollment.setGrade(grade);
	 enrollment.setStatus(EnrollmentStatus.COMPLETED);
	 
 } 
 
 public Set<Student> getSortedRoster(String courseCode) {
	    Course course = findCourse(courseCode);
	    return course.getSortedRoster(students);
	}

 
 
 
}







