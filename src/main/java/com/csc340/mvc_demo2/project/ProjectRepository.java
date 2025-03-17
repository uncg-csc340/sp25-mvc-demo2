package com.csc340.mvc_demo2.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select * from projects p where p.team_id = ?1", nativeQuery = true)
    List<Project> findByTeamId(int teamId);
}
