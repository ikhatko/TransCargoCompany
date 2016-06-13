package model.Entities;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    private String cityName;

    private long distance;

    public City() {
    }

    public City(String cityName, long distance) {
        this.cityName = cityName;
        this.distance = distance;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "" + cityId;
    }
}
