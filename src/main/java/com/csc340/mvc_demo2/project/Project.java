package com.csc340.mvc_demo2.project;

import com.csc340.mvc_demo2.team.Team;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;


    @OneToOne
    @JoinColumn(name = "teamId")
    private Team team;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private String status;

    public Project() {

    }

    public Project(Team team, @Nonnull String title, String description, @Nonnull String status) {
        this.team = team;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Project(Team team, @Nonnull String title, @Nonnull String status) {
        this.team = team;
        this.title = title;
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Team getGroup() {
        return team;
    }

    public void setGroup(Team team) {
        this.team = team;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nonnull
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nonnull String status) {
        this.status = status;
    }
}
