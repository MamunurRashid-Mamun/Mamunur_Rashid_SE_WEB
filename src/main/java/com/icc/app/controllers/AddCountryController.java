package com.icc.app.controllers;

import com.icc.app.dto.Country;
import com.icc.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddCountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/addCountry", method = RequestMethod.GET)
    public String showAddCountryPage() {
        return "addCountry";
    }

    @RequestMapping(value = "/addCountry", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute("countryName") String countryName) {
        Country country = new Country(countryName);
        countryService.saveCountry(country);
        return "home";
    }
}
