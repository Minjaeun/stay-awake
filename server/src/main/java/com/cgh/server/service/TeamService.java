package com.cgh.server.service;

import com.cgh.server.domain.Team;
import com.cgh.server.domain.Member;
import com.cgh.server.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findByMember(Member member){
        return teamRepository.findByMember(member);
    }



    public void save(Team team) {
        teamRepository.save(team);
    }
}
