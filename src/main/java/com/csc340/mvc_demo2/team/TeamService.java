package com.csc340.mvc_demo2.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamById(int teamId){
        return teamRepository.findById(teamId).orElse(null);
    }

    public void addNewTeam(Team team){
        teamRepository.save(team);
    }

    public void deleteTeamById(int teamId){
        teamRepository.deleteById(teamId);
    }
}
