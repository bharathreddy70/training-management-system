package com.tms.model.course;

public class OnlineCourse extends Course {

    private String platform; // e.g., Teams, Zoom

    public OnlineCourse(String courseCode, String title, Integer capacity, String platform) {
        super(courseCode, title, capacity);
        this.platform = platform;
    }

    // Getter and setter
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "OnlineCourse [courseCode=" + getId() + ", title=" + getTitle() +
               ", capacity=" + getCapacity() + ", platform=" + platform + "]";
    }
}
