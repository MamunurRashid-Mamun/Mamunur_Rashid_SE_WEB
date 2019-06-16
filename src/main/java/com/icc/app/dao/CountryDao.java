package com.icc.app.dao;

import com.icc.app.dto.Country;

import java.util.List;

public interface CountryDao {
    public void saveCountry(Country country);
    public void updateCountry(Country country);
    public void deleteCountry(Country country);
    public List<Country> getAllCountry();
}
