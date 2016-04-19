package com.example.kristin.weathertoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import Data.WeatherProviderHC;
import Model.Weather;
import Model.WeatherHC;

public class DetailedInformationActivity extends AppCompatActivity {

    List<WeatherHC> cityList;
    Intent intent = getIntent();
    //int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);

    //int position = intent.getSerializableExtra("position");
    //int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE);
    TextView name, temperature, clouds, date, wind, cloudiness, pressure, humidity, sunrise, sunset, coords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_information);

        cityList = new WeatherProviderHC().readWeather();

        name = (TextView)findViewById(R.id.city_name);
        name.setText(cityList.get(0).getCity());
        temperature = (TextView)findViewById(R.id.city_temperature);
        temperature.setText(cityList.get(0).getTemperature());
        wind = (TextView)findViewById(R.id.city_wind);
        wind.setText(cityList.get(0).getWind());
        cloudiness = (TextView)findViewById(R.id.city_cloudiness);
        cloudiness.setText(cityList.get(0).getCloudiness());
        pressure = (TextView)findViewById(R.id.city_pressure);
        pressure.setText(cityList.get(0).getPressure());
        humidity = (TextView)findViewById(R.id.city_humidity);
        humidity.setText(cityList.get(0).getHumidity());
        sunrise = (TextView)findViewById(R.id.city_sunrise);
        sunrise.setText(cityList.get(0).getSunrise());
        sunset = (TextView)findViewById(R.id.city_sunset);
        sunset.setText(cityList.get(0).getSunset());
        coords = (TextView)findViewById(R.id.city_coords);
        coords.setText(cityList.get(0).getGeoCoords());
    }
}
