package com.csc340.mvc_demo2.project;

import com.csc340.mvc_demo2.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @Autowired
    public TeamService teamService;



    @GetMapping("/all")
    public Object getAllProjects() {

        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public Object getProjectById(@PathVariable int projectId) {
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @PostMapping("/add-team-project")
    public Object addNewProject(@RequestBody Project project) {
        System.out.println(project.toString());
        projectService.addNewProject(project);
        int projectTeamId=project.getTeam().getTeamId();
        return new ResponseEntity<>(teamService.getTeamById(projectTeamId), HttpStatus.OK);
    }

    @PostMapping("/update/{projectId}")
    public Object updateProject(@PathVariable int projectId, Project project) {
        projectService.addNewProject(project);
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projectId}")
    public Object deleteProject(@PathVariable int projectId) {
        int projectTeamId= projectService.getProjectById(projectId).getTeam().getTeamId();
        projectService.deleteProjectById(projectId);
        return new ResponseEntity<>(teamService.getTeamById(projectTeamId), HttpStatus.OK);
    }

}
