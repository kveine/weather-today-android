package Data;

import java.util.Arrays;
import java.util.List;

import Model.WeatherHC;

/**
 * Created by Kristin on 19.04.2016.
 */
public class WeatherProviderHC {
    public List<WeatherHC> readWeather() {
        return Arrays.asList(
                new WeatherHC("Oslo", "9°C", "7.2", "Clear Sky", "1008 hpa", "30%", "1461037589", "1461091620", "[10.75, 59.91]", "d01"),
                new WeatherHC("Bergen", "8°C", "7.2", "Broken clouds", "1018 hpa", "81%", "1461038780", "1461093033", "[5.33, 60.39]", "d04"),
                new WeatherHC("Stavanger", "10°C", "9.3", "Few clouds", "1019 hpa", "70%", "1461038995", "1461092618", "[5.73, 58.97]", "d02"),
                new WeatherHC("Trondheim", "11°C", "8.7", "Scattered clouds", "1011 hpa", "74%", "1461036777", "1461092622", "[10.4, 63.43]", "d03")
        );
    }
}
