package com.icc.app.services;

import com.icc.app.dao.CountryDao;
import com.icc.app.dao.CountryDaoImp;
import com.icc.app.dto.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryDaoImp countryDaoImp;

    public void saveCountry(Country country){
        countryDaoImp.saveCountry(country);
    }

    public List<Country> getAllCountry(){
        return countryDaoImp.getAllCountry();
    }

    public void updateCountry(Country country) {
        countryDaoImp.updateCountry(country);
    }

    public void deleteCountry(Country country) {
        countryDaoImp.deleteCountry(country);
    }

    public Country getCountryById(Long countryId) {
        return countryDaoImp.getCountryById(countryId);
    }
}
