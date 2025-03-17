package com.csc340.mvc_demo2.student;

import com.csc340.mvc_demo2.team.Team;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(nullable = false)
    private String name;

    private String major;

    @Column(nullable = false)
    private double gpa;


    @ManyToOne
    @JoinColumn(name = "teamId", nullable = true)
    private Team team;


    public Student(int studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
    }

    public Student(int studentId, String name, String major, double gpa, Team team) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.team = team;
    }

    public Student(String name, String major, double gpa, Team team) {
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        this.team = team;
    }

    //Always include a no-argument constructor.
    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", team=" + team +
                '}';
    }
}

