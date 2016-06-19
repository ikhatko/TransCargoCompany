package model.Entities;

import javax.persistence.*;

/**
 * The type City.
 */
@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    private String cityName;

    /**
     * Instantiates a new City.
     */
    public City() {
    }

    /**
     * Instantiates a new City.
     *
     * @param cityName the city name
     */
    public City(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets city id.
     *
     * @return the city id
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * Sets city id.
     *
     * @param cityId the city id
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets city name.
     *
     * @param cityName the city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "" + cityName;
    }
}
