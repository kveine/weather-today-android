package com.example.kristin.weathertoday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Model.WeatherPOJO;

public class DetailedInformationActivity extends AppCompatActivity {

    ArrayList<WeatherPOJO> weatherList;
    int position;
    TextView name, temperature, wind, cloudiness, pressure, humidity, sunrise, sunset, coords;
    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_information);
        //weatherList = new ArrayList<>();
        Intent intent = getIntent();
        position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, 0);
        //weatherList = intent.getParcelableArrayListExtra(MainActivity.EXTRA_MESSAGE_ARRAY);

        /*weatherList = new WeatherProviderHC().readWeather();

        name = (TextView)findViewById(R.id.city_name);
        name.setText(weatherList.get(position).getCity());
        temperature = (TextView)findViewById(R.id.city_temperature);
        temperature.setText(weatherList.get(position).getTemperature().toString() + "°C");
        wind = (TextView)findViewById(R.id.city_wind);
        wind.setText(weatherList.get(position).getWind().toString());
        cloudiness = (TextView)findViewById(R.id.city_cloudiness);
        cloudiness.setText(weatherList.get(position).getCloudiness());
        pressure = (TextView)findViewById(R.id.city_pressure);
        pressure.setText(weatherList.get(position).getPressure().toString() + "hpa");
        humidity = (TextView)findViewById(R.id.city_humidity);
        humidity.setText(weatherList.get(position).getHumidity().toString() + "%");
        sunrise = (TextView)findViewById(R.id.city_sunrise);
        sunrise.setText(weatherList.get(position).getSunrise().toString());
        sunset = (TextView)findViewById(R.id.city_sunset);
        sunset.setText(weatherList.get(position).getSunset().toString());
        coords = (TextView)findViewById(R.id.city_coords);
        coords.setText(weatherList.get(position).getGeoCoords());
        icon = (ImageView)findViewById(R.id.city_icon);

        switch (weatherList.get(position).getIcon()){
            case "d01":
                icon.setImageResource(R.drawable.d01);
                break;
            case "d02":
                icon.setImageResource((R.drawable.d02));
                break;
            case "d03":
                icon.setImageResource(R.drawable.d03);
                break;
            case "d04":
                icon.setImageResource(R.drawable.d04);
                break;
        }*/
    }
}
