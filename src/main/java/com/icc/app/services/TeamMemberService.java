package com.icc.app.services;

import com.icc.app.dao.TeamMemberDaoImp;
import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {
    @Autowired
    TeamMemberDaoImp teamMemberDaoImp;

    public void saveTeamMember(TeamMember teamMember){
        teamMemberDaoImp.saveTeamMember(teamMember);
    }

    public List<TeamMember> getAllCountry(){
        return teamMemberDaoImp.getAllTeamMember();
    }

    public void updateTeamMember(TeamMember teamMember) {
        teamMemberDaoImp.updateTeamMember(teamMember);
    }

    public void deleteTeamMember(TeamMember teamMember) {
        teamMemberDaoImp.deleteTeamMember(teamMember);
    }

    public TeamMember getTemMemberById(Long teamMemberId) {
        return teamMemberDaoImp.getTeamMemberById(teamMemberId);
    }
}
