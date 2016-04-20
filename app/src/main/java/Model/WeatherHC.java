package Model;

import java.util.Date;

/**
 * Created by Kristin on 19.04.2016.
 */
public class WeatherHC {
    private final String city;
    private final Integer temperature;
    private final Double wind;
    private final String cloudiness;
    private final Integer pressure;
    private final Integer humidity;
    private final Integer sunrise;
    private final Integer sunset;
    private final String geoCoords;
    private final String icon;


    public WeatherHC(String city, Integer temperature, Double wind, String cloudiness, Integer pressure,
                     Integer humidity, Integer sunrise, Integer sunset, String geoCoords, String icon) {
        this.city = city;
        this.temperature = temperature;
        this.wind = wind;
        this.cloudiness = cloudiness;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.geoCoords = geoCoords;
        this.icon = icon;
    }

    public String getCity() {
        return city;
    }

    public Integer getTemperature(){
        return temperature;
    }

    public Double getWind(){
        return wind;
    }

    public String getCloudiness(){
        return cloudiness;
    }

    public Integer getPressure(){
        return pressure;
    }

    public Integer getHumidity(){
        return humidity;
    }

    public Integer getSunrise(){
        return sunrise;
    }

    public Integer getSunset(){
        return sunset;
    }

    public String getGeoCoords(){
        return geoCoords;
    }

    public String getIcon(){ return icon; }
}
