package com.icc.app.controllers;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import com.icc.app.services.CountryService;
import com.icc.app.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamMemberRestController {
    @Autowired
    TeamMemberService teamMemberService;
    @Autowired
    CountryService countryService;

    @GetMapping("/teamMembers")
    @ResponseBody
    public List<TeamMember> getTeamMembersByCountry(@ModelAttribute("countryId") String countryId){
        Country country = countryService.getCountryById(Long.parseLong(countryId));
        return teamMemberService.findTeamMemberByCountry(country);
    }
}
