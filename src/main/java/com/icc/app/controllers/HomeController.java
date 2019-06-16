package com.icc.app.controllers;
import com.icc.app.dto.Country;
import com.icc.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
//    @Autowired
//    CountryService countryService;
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ModelAndView showCountryList() {
//        List<Country> countries = new ArrayList<>();
//        countries = countryService.getAllCountry();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("countries",countries);
//        return modelAndView;
//    }
}
