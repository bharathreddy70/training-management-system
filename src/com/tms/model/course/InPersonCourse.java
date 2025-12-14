package com.tms.model.course;

public class InPersonCourse extends Course {

    private String room; // e.g., Mumbai Training Room

    public InPersonCourse(String courseCode, String title, Integer capacity, String room) {
        super(courseCode, title, capacity);
        this.room = room;
    }

    // Getter and setter
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "InPersonCourse [courseCode=" + getId() + ", title=" + getTitle() +
               ", capacity=" + getCapacity() + ", room=" + room + "]";
    }
}
