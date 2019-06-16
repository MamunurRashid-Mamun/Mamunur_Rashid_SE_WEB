package com.icc.app.dao;

import com.icc.app.dto.Country;

import java.util.List;
import java.util.Optional;

public interface CountryDao {
    void saveCountry(Country country);
    void updateCountry(Country country);
    void deleteCountry(Country country);
    List<Country> getAllCountry();
    Country getCountryById(Long countryId);
}
