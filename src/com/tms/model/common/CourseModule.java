package com.tms.model.common;

import com.tms.interfaces.Nameable;

public class CourseModule implements Nameable {

    private String title;
    private int duration; 

    public CourseModule(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String getName() {
        return title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
