package Model;

/**
 * Created by Kristin on 19.04.2016.
 */
public class WeatherHC {
    private final String city;
    private final String temperature;
    private final String wind;
    private final String cloudiness;
    private final String pressure;
    private final String humidity;
    private final String sunrise;
    private final String sunset;
    private final String geoCoords;
    private final String icon;


    public WeatherHC(String city, String temperature, String wind, String cloudiness, String pressure,
                     String humidity, String sunrise, String sunset, String geoCoords, String icon  ) {
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

    public String getTemperature(){
        return temperature;
    }

    public String getWind(){
        return wind;
    }

    public String getCloudiness(){
        return cloudiness;
    }

    public String getPressure(){
        return pressure;
    }

    public String getHumidity(){
        return humidity;
    }

    public String getSunrise(){
        return sunrise;
    }

    public String getSunset(){
        return sunset;
    }

    public String getGeoCoords(){
        return geoCoords;
    }

    public String getIcon(){ return icon; }
}
