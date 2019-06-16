package com.icc.app.dao;

import com.icc.app.dto.Country;
import com.icc.app.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryDaoImp implements CountryDao {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long countryId) {
        return countryRepository.findByCountryId(countryId);
    }


}
