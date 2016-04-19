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
                new WeatherHC("Oslo", "9°", "7.2", "Clear Sky", "1008 hpa", "30%", "1461037589", "1461091620", "[10.75, 59.91]"),
                new WeatherHC("Bergen", "8°", "7.2", "shower rain", "1018 hpa", "81%", "1461038780", "1461093033", "[5.33, 60.39]"),
                new WeatherHC("Stavanger", "10°", "9.3", "shower rain", "1019 hpa", "70%", "1461038995", "1461092618", "[5.73, 58.97]"),
                new WeatherHC("Trondheim", "11°", "8.7", "broken clouds", "1011 hpa", "74%", "1461036777", "1461092622", "[10.4, 63.43]")
        );
    }
}
