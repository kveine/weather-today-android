package Interface;

import java.util.List;

import Model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kristin on 18.04.2016.
 */
public interface WeatherAPI {
    @GET("weather")
    //void getWeatherInformation(@Query("q") String city, @Query("appid") String appID, Callback<WeatherPOJO> callback);
    Call<WeatherPOJO> getWeatherInformation(@Query("q") String city, @Query("appid") String appID); //@Query("q") String city, @Query("appid") String appID
}
