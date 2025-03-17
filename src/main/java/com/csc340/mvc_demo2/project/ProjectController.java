package com.csc340.mvc_demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @GetMapping("/all")
    public Object getAllProjects(Model model){
        model.addAttribute("projectList", projectService.getAllProjects());
        model.addAttribute("title", "All Projects");
        return "project/project-list";
    }

    @GetMapping("/{projectId}")
    public Object getProjectById(@PathVariable int projectId, Model model){
        model.addAttribute("project", projectService.getProjectById(projectId));
        model.addAttribute("title", "Project #: " + projectId);
        return "project/project-details";
    }

    @PostMapping("/new")
    public Object addNewProject(Project project){
        projectService.addNewProject(project);
        return "redirect:/teams/"+project.getTeam().getTeamId();
    }

    @GetMapping("/updateForm/{projectId}")
    public Object showUpdateForm(@PathVariable int projectId,  Model model){
        model.addAttribute("project", projectService.getProjectById(projectId));
        model.addAttribute("title", "Update Project");
        return "project/project-update";
    }

    @PostMapping("/update/{projectId}")
    public Object updateProject(@PathVariable int projectId, Project project){
        projectService.addNewProject(project);
        return "redirect:/projects/" + projectId;
    }

        @GetMapping("/delete/{projectId}")
    public Object deleteProject(@PathVariable int projectId){
        Project project = projectService.getProjectById(projectId);
        projectService.deleteProjectById(projectId);
        return "redirect:/teams/"+project.getTeam().getTeamId();
    }

}
