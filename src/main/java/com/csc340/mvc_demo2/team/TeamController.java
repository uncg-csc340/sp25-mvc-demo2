package com.csc340.mvc_demo2.team;

import com.csc340.mvc_demo2.project.Project;
import com.csc340.mvc_demo2.project.ProjectService;
import com.csc340.mvc_demo2.student.Student;
import com.csc340.mvc_demo2.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ProjectService projectService;


    @GetMapping("/all")
    public Object getAllTeams() {
                return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public Object getTeamById(@PathVariable int teamId) {
        return new ResponseEntity<>(teamService.getTeamById(teamId), HttpStatus.OK);
    }

    @PostMapping("/register")
    public Object addNewTeam(@RequestBody Team team) {
        teamService.addNewTeam(team);
        return new ResponseEntity<>("New Team Successfully Created!", HttpStatus.CREATED);
    }


    @PostMapping("/update/{teamId}")
    public Object updateTeam(@PathVariable int teamId, @RequestBody Team team) {
        teamService.addNewTeam(team);
        return new ResponseEntity<>(teamService.getTeamById(teamId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{teamId}")
    public Object deleteTeamById(@PathVariable int teamId) {
        //Or use CASCADE to handle this.
        for (Project project : projectService.getProjectsByTeam(teamId))
            projectService.deleteProjectById(project.getProjectId());
        for (Student student : studentService.getStudentsByTeam(teamId)) {
            student.setTeam(null);
            studentService.updateStudent(student);
        }
        teamService.deleteTeamById(teamId);
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }


}
