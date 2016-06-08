package model.DAO.Interfaces;

import model.Entities.City;

public interface CityDAO {
    City getCityById(int cityId);
    void createCity(City city);
    void updateCity(City city);
    void deleteCityById(int cityId);
}
