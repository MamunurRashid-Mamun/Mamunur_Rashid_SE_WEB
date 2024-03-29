package com.icc.app.controllers;

import com.icc.app.dto.Country;
import com.icc.app.services.CountryService;
import com.icc.app.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {
    @Autowired
    CountryService countryService;
    @Autowired
    TeamMemberService teamMemberService;
//  Pulling all county data from database and showing it in homepage
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showCountryList() {
        List<Country> countries = new ArrayList<>();
        countries = countryService.getAllCountry();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countries",countries);
        modelAndView.setViewName("home");
        return modelAndView;
    }

//    Showing page for adding county to database
    @RequestMapping(value = "/addCountry", method = RequestMethod.GET)
    public String showAddCountryPage() {
        return "addCountry";
    }

//    Saving Country to database
    @RequestMapping(value = "/addCountry", method = RequestMethod.POST)
    public ModelAndView addCountry(@ModelAttribute("countryName") String countryName) {
        ModelAndView modelAndView = new ModelAndView();
        Country country = new Country(countryName);
        countryService.saveCountry(country);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

//    Showing page for updating country info
    @RequestMapping(value = "/updateCountry", method = RequestMethod.GET)
    public ModelAndView showUpdateCountryPage(@ModelAttribute("countryId") Long countryId) {
        ModelAndView modelAndView = new ModelAndView();
        Country country = countryService.getCountryById(countryId);
        modelAndView.addObject("country",country);
        modelAndView.setViewName("updateCountry");
        return modelAndView;
    }

//    updating country data in database and then redirecting to homepage
    @RequestMapping(value = "/updateCountry", method = RequestMethod.POST)
    public ModelAndView updateCountry(@ModelAttribute Country country) {
        ModelAndView modelAndView = new ModelAndView();
        Country tempCountry = countryService.getCountryById(country.getCountryId());
        tempCountry.setCountryName(country.getCountryName());
        countryService.updateCountry(tempCountry);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

//    Deleting country by country Id and then redirecting to homepage. Also Deleting all the team member of that country.
    @RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
    public ModelAndView deleteCountry(@ModelAttribute("countryId") Long countryId) {
        ModelAndView modelAndView = new ModelAndView();
        Country country = countryService.getCountryById(countryId);
        teamMemberService.deleteTeamMemberByCountry(country);
        countryService.deleteCountry(country);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
