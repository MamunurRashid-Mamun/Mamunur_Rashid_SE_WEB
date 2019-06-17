package com.icc.app.controllers;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import com.icc.app.services.CountryService;
import com.icc.app.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamMemberRestController {
    @Autowired
    TeamMemberService teamMemberService;
    @Autowired
    CountryService countryService;

//    Getting all team member by ajax call
    @GetMapping("/teamMembers")
    @ResponseBody
    public List<TeamMember> getTeamMembersByCountry(@ModelAttribute("countryId") String countryId){
        Country country = countryService.getCountryById(Long.parseLong(countryId));
        return teamMemberService.findTeamMemberByCountry(country);
    }

//    Deleting specific team member by ajax call
    @DeleteMapping("/deleteTeamMember")
    public long deleteTeamMember(@ModelAttribute("teamMemberId") String teamMemberId){
        TeamMember teamMember = teamMemberService.getTemMemberById(Long.parseLong(teamMemberId));
        long countryId = teamMember.getCountry().getCountryId();
        teamMemberService.deleteTeamMember(teamMember);
        return countryId;
    }
}
