/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentsoapservice;

/**
 *
 * @author user
 */

import java.io.Serializable;

public class Student implements Serializable {
    private int studentId;
    private double studyHoursPerDay;
    private double extracurricularHoursPerDay;
    private double sleepHoursPerDay;
    private double socialHoursPerDay;
    private double physicalActivityHoursPerDay;
    private double gpa;
    private String stressLevel;

    public Student() {}

    public Student(int studentId, double studyHoursPerDay, double extracurricularHoursPerDay,
                   double sleepHoursPerDay, double socialHoursPerDay, double physicalActivityHoursPerDay,
                   double gpa, String stressLevel) {
        this.studentId = studentId;
        this.studyHoursPerDay = studyHoursPerDay;
        this.extracurricularHoursPerDay = extracurricularHoursPerDay;
        this.sleepHoursPerDay = sleepHoursPerDay;
        this.socialHoursPerDay = socialHoursPerDay;
        this.physicalActivityHoursPerDay = physicalActivityHoursPerDay;
        this.gpa = gpa;
        this.stressLevel = stressLevel;
    }

    // Getters et Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(double studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public double getExtracurricularHoursPerDay() {
        return extracurricularHoursPerDay;
    }

    public void setExtracurricularHoursPerDay(double extracurricularHoursPerDay) {
        this.extracurricularHoursPerDay = extracurricularHoursPerDay;
    }

    public double getSleepHoursPerDay() {
        return sleepHoursPerDay;
    }

    public void setSleepHoursPerDay(double sleepHoursPerDay) {
        this.sleepHoursPerDay = sleepHoursPerDay;
    }

    public double getSocialHoursPerDay() {
        return socialHoursPerDay;
    }

    public void setSocialHoursPerDay(double socialHoursPerDay) {
        this.socialHoursPerDay = socialHoursPerDay;
    }

    public double getPhysicalActivityHoursPerDay() {
        return physicalActivityHoursPerDay;
    }

    public void setPhysicalActivityHoursPerDay(double physicalActivityHoursPerDay) {
        this.physicalActivityHoursPerDay = physicalActivityHoursPerDay;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(String stressLevel) {
        this.stressLevel = stressLevel;
    }
}