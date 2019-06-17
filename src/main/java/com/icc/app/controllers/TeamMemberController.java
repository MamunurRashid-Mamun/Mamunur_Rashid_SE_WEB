package com.icc.app.controllers;

import com.icc.app.dto.Country;
import com.icc.app.dto.TeamMember;
import com.icc.app.services.CountryService;
import com.icc.app.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeamMemberController {
    @Autowired
    CountryService countryService;
    @Autowired
    TeamMemberService teamMemberService;

//    Showing team member registration page and populate country select option
    @RequestMapping(value = "/registerTeamMember", method = RequestMethod.GET)
    public ModelAndView showTeamMemberRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Country> countries = countryService.getAllCountry();
        modelAndView.addObject("countries",countries);
        modelAndView.addObject("teamMember", new TeamMember());
        modelAndView.setViewName("registerTeamMember");
        return modelAndView;
    }

//    Finding Country of a team member by country id. Setting the country as team member's country.
//    And finally saving team member data to database.
    @RequestMapping(value = "/registerTeamMember", method = RequestMethod.POST)
    public ModelAndView registerTeamMember(@ModelAttribute TeamMember teamMember, @ModelAttribute("countryId") String countryId) {
        ModelAndView modelAndView = new ModelAndView();
        Country country = countryService.getCountryById(Long.parseLong(countryId));
        teamMember.setCountry(country);
        teamMemberService.saveTeamMember(teamMember);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

//    Showing team member editing page
    @RequestMapping(value = "/editTeamMember", method = RequestMethod.GET)
    public ModelAndView showEditTeamMemberPage(@ModelAttribute("teamMemberId") String teamMemberId) {
        ModelAndView modelAndView = new ModelAndView();
        TeamMember teamMember = teamMemberService.getTemMemberById(Long.parseLong(teamMemberId));
        modelAndView.addObject("teamMember", teamMember);
        List<Country> countries = countryService.getAllCountry();
        modelAndView.addObject("countries",countries);
        modelAndView.setViewName("editTeamMember");
        return modelAndView;
    }

    //    Updating team member
    @RequestMapping(value = "/editTeamMember", method = RequestMethod.POST)
    public ModelAndView updateTeamMemberPage(@ModelAttribute TeamMember teamMember, @ModelAttribute("countryId") String countryId) {
        Country country = countryService.getCountryById(Long.parseLong(countryId));
        TeamMember tempTeamMember = teamMemberService.getTemMemberById(teamMember.getTeamMemberId());
        tempTeamMember.setName(teamMember.getName());
        tempTeamMember.setAge(teamMember.getAge());
        tempTeamMember.setRole(teamMember.getRole());
        tempTeamMember.setDateOfBirth(teamMember.getDateOfBirth());
        tempTeamMember.setCountry(country);
        teamMemberService.saveTeamMember(tempTeamMember);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
