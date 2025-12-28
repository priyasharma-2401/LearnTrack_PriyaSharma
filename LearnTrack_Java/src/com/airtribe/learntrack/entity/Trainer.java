package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    private String course;
    private int experienceInYrs;

    @Override
    public String getDisplayName() {
        return "Trainer: " + super.getDisplayName();
    }
    public Trainer(int id, String firstName, String lastName, String email, String course, int experience) {
        super(id, firstName, lastName, email);
        this.experienceInYrs = experience;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getExperienceInYrs() {
        return experienceInYrs;
    }

    public void setExperienceInYrs(int experienceInYrs) {
        this.experienceInYrs = experienceInYrs;
    }
}
