package com.icc.app.dao;

import com.icc.app.dto.TeamMember;
import com.icc.app.repositories.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamMemberDaoImp implements TeamMemberDao{
    @Autowired
    TeamMemberRepository teamMemberRepository;
    @Override
    public void saveTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
    }

    @Override
    public void updateTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
    }

    @Override
    public void deleteTeamMember(TeamMember teamMember) {
        teamMemberRepository.delete(teamMember);
    }

    @Override
    public List<TeamMember> getAllTeamMember() {
        return teamMemberRepository.findAll();
    }

    @Override
    public TeamMember getTeamMemberById(Long teamMemberId) {
        return teamMemberRepository.findByTeamMemberId(teamMemberId);
    }
}
