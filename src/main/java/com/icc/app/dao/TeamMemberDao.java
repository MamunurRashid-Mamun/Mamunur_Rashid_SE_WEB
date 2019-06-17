package com.icc.app.dao;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;

import java.util.List;

public interface TeamMemberDao {
    void saveTeamMember(TeamMember teamMember);
    void updateTeamMember(TeamMember teamMember);
    void deleteTeamMember(TeamMember teamMember);
    void deleteTeamMemberById(Long teamMemberId);
    List<TeamMember> getAllTeamMember();
    TeamMember getTeamMemberById(Long teamMemberId);
    List<TeamMember> findByCountry(Country country);
    void deleteTeamMemberByCountry(Country country);
}
