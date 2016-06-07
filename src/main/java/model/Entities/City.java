package model.Entities;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    private String cityName;

    public City() {
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
}
