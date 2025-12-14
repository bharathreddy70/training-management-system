package com.tms.main;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

import com.tms.model.common.CourseModule;
import com.tms.model.course.Course;
import com.tms.model.course.InPersonCourse;
import com.tms.model.course.OnlineCourse;
import com.tms.model.course.Session;
import com.tms.model.person.Student;
import com.tms.model.person.Trainer;
import com.tms.service.TrainingManagementService;

public class Main {

    public static void main(String[] args) {

	TrainingManagementService service = new TrainingManagementService();
	Scanner sc = new Scanner(System.in);
	
	boolean running = true;
	
	while (running) {
	    System.out.println("\n====== Training Management System ======");
	    System.out.println("1. Add Course");
	    System.out.println("2. Register Student");
	    System.out.println("3. Register Trainer");	    
	    System.out.println("4. Add Module to Course");
	    System.out.println("5. Add Session to Course");
	    System.out.println("6. Enroll Student");
	    System.out.println("7. Record Grade");
	    System.out.println("8. View Sorted Roster");
	    System.out.println("9. View Course Schedule");
	    System.out.println("0. Exit");
	    System.out.print("Choose option: ");
	
	    int choice = sc.nextInt();
	    sc.nextLine(); // consume newline
	
	    try {
	        switch (choice) {
	
	        // ---------------- Add Course ----------------
	        case 1:
	            System.out.print("Course Type (1-Online, 2-InPerson): ");
	            int type = sc.nextInt();
	            sc.nextLine();
	
	            System.out.print("Course Code: ");
	            String code = sc.nextLine();
	
	            System.out.print("Title: ");
	            String title = sc.nextLine();
	
	            System.out.print("Capacity: ");
	            int capacity = sc.nextInt();
	            sc.nextLine();
	
	            Course course;
	            if (type == 1) {
	                System.out.print("Platform: ");
	                String platform = sc.nextLine();
	                course = new OnlineCourse(code, title, capacity, platform);
	            } else {
	                System.out.print("Room: ");
	                String room = sc.nextLine();
	                course = new InPersonCourse(code, title, capacity, room);
	            }
	
	            service.addCourse(course);
	            System.out.println("-->Course added successfully.<--");
	            break;
	
	        // ---------------- Register Student ----------------
	        case 2:
	            System.out.print("Student ID: ");
	            Long studentId = sc.nextLong();
	            sc.nextLine();
	
	            System.out.print("Student Name: ");
	            String name = sc.nextLine();
	
	            Student student = new Student(studentId, name);
	            service.registerStudent(student);
	
	            System.out.println("-->Student registered successfully.<--");
	            break;
	
	         // ---------------- Register Trainer ----------------
	        case 3:
	            System.out.print("Trainer ID: ");
	            Long trainerId = sc.nextLong();
	            sc.nextLine();

	            System.out.print("Trainer Name: ");
	            String trainerName = sc.nextLine();

	            System.out.print("Number of expertise skills: ");
	            int expCount = sc.nextInt();
	            sc.nextLine();

	            Trainer trainer = new Trainer(trainerId, trainerName);

	            for (int i = 1; i <= expCount; i++) {
	                System.out.print("Expertise " + i + ": ");
	                trainer.setExpertise(sc.nextLine());
	            }

	            service.registerTrainer(trainer);
	            System.out.println("-->Trainer registered successfully.<--");
	            break;
     
	            
	            
	            
	            
	            
	            
	            
	            
	        // ---------------- Add Module ----------------
	        case 4:
	            System.out.print("Course Code: ");
	            String mCourseCode = sc.nextLine();
	            System.out.println("Enter number of modules to be added:");
	            int mCount=sc.nextInt();
	            sc.nextLine();
	            for(int i=1;i<=mCount;i++) {
	            	
	              System.out.print(i+".Module Title: ");
	              String mTitle = sc.nextLine();
	
	              System.out.print("Duration (hours): ");
	              int duration = sc.nextInt();
	              sc.nextLine();
	   
	            
	              service.findCourse(mCourseCode)
	              .addModule(new CourseModule(mTitle, duration));
	              System.out.println("-->Module added.<--");
	            }
	            break;
	
	        // ---------------- Add Session ----------------
	        case 5:
	            System.out.print("Course Code: ");
	            String sCourseCode = sc.nextLine();
	            System.out.println("Enter number of sessions to be added:");
	            int sCount=sc.nextInt();
	            sc.nextLine();
	            for(int i=1;i<=sCount;i++) {
	              System.out.print(i+".Topic: ");
	              String topic = sc.nextLine();
	
	              System.out.print("DateTime (yyyy-MM-dd HH:mm): ");
	              String dateTime = sc.nextLine();
	            
	              LocalDateTime dt = LocalDateTime.parse(
	                dateTime.replace(" ", "T")
	              );
	            
	              service.findCourse(sCourseCode)
	                   .addSession(new Session(dt, topic));
	
	              System.out.println("-->Session added.<--");
	            }
	            break;
	
	        // ---------------- Enroll Student ----------------
	        case 6:
	              System.out.print("Student ID: ");
	              Long eStudentId = sc.nextLong();
	              sc.nextLine();
	
	              System.out.print("Course Code: ");
	              String eCourseCode = sc.nextLine();
	
	              service.enrollStudent(eStudentId, eCourseCode);
	              System.out.println("-->Student enrolled.<--");
	            break;
	
	        // ---------------- Record Grade ----------------
	        case 7:
	            System.out.print("Student ID: ");
	            Long gStudentId = sc.nextLong();
	            sc.nextLine();
	
	            System.out.print("Course Code: ");
	            String gCourseCode = sc.nextLine();
	
	            System.out.print("Grade (0-100): ");
	            int grade = sc.nextInt();
	            sc.nextLine();
	
	            service.recordGrade(gStudentId, gCourseCode, grade);
	            System.out.println("-->Grade recorded.<--");
	            break;
	
	        // ---------------- View Sorted Roster ----------------
	        case 8:
	            System.out.print("Course Code: ");
	            String rCourseCode = sc.nextLine();
	
	            Set<Student> roster =
	                service.getSortedRoster(rCourseCode);
	
	            System.out.println("-->Sorted Roster:<--");

	            service.findCourse(rCourseCode)
	                   .getEnrollments()
	                   .forEach(e -> {
	                       Student s = service.findStudent(e.getStudentId());
	                       System.out.println(
	                           s.getId() + " - " +
	                           s.getName() + " | Status: " +
	                           e.getStatus() +
	                           (e.getGrade() != null ? " | Grade: " + e.getGrade() : "")
	                       );
	                   });

	            break;
	
	        // ---------------- View Schedule ----------------
	        case 9:
	            System.out.print("Course Code: ");
	            String schCourseCode = sc.nextLine();
	            System.out.println("---SCHEDULE---");
	            service.findCourse(schCourseCode)
	                   .getSchedule()
	                   .forEach((time, session) ->
	                       System.out.println(" "+time + " -> " + session.getTopic())
	                   );
	            break;
	
	        case 0:
	            running = false;
	            System.out.println("Exiting...");
	            break;
	
	        default:
	            System.out.println("Invalid option!!");
	        }
	
	    }catch (Exception e) {
	        System.out.println("ERROR: " + e.getMessage());
	        }
	    }
	
	    sc.close();
	}
}
