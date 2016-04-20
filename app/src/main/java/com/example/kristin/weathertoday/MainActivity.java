package com.example.kristin.weathertoday;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Data.WeatherProviderHC;
import Interface.WeatherAPI;
import Model.WeatherHC;
import Model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.kristin.cardviewtest.position";
    //These WeatherPOJO objects were made to store the different call data and to be added to List<WeatherPOJO> weatherList
    /*WeatherPOJO osloInfo, bergenInfo, trondheimInfo, stavangerInfo;
    List<WeatherPOJO> weatherList;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Code to collect data using Retrofit
        /*Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);

        Call<WeatherPOJO> callOslo = weatherAPI.getWeatherInformation("oslo", "5a3d6fa759a2e9ecd6ade28247c684d3");
        callOslo.enqueue(new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                if (response.isSuccessful()) {
                    //osloInfo = response.body();
                    //weatherList.add(osloInfo);
                }
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {

            }

        });

        Call<WeatherPOJO> callBergen = weatherAPI.getWeatherInformation("bergen", "5a3d6fa759a2e9ecd6ade28247c684d3");
        callBergen.enqueue(new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                if (response.isSuccessful()) {
                    //bergenInfo = response.body();
                    //weatherList.add(bergenInfo);
                }
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {

            }
        });

        Call<WeatherPOJO> callTrondheim = weatherAPI.getWeatherInformation("trondheim","5a3d6fa759a2e9ecd6ade28247c684d3");
        callTrondheim.enqueue(new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                if (response.isSuccessful()) {
                    //trondheimInfo = response.body();
                    //weatherList.add(trondheimInfo);
                }
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {

            }
        });

        Call<WeatherPOJO> callStavanger = weatherAPI.getWeatherInformation("stavanger","5a3d6fa759a2e9ecd6ade28247c684d3");
        callStavanger.enqueue(new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                if (response.isSuccessful()) {
                    //stavangerInfo = response.body();
                    //weatherList.add(stavangerInfo);
                }
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {

            }
        });*/

        RecyclerView rv = (RecyclerView) findViewById(R.id.city_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //weatherList storing the different WeatherPOJO object should be the parameter here
        rv.setAdapter(new WeatherListAdapter(new WeatherProviderHC().readWeather()));
    }


    class WeatherListAdapter extends RecyclerView.Adapter<WeatherViewHolder>{
        private final List<WeatherHC> cities;


        WeatherListAdapter(List<WeatherHC> cities){
            this.cities = cities;
        }

        @Override
        public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            final View view = layoutInflater.inflate(R.layout.cardsview_layout, parent, false);
            return new WeatherViewHolder(view);
        }

        @Override
        public void onBindViewHolder(WeatherViewHolder holder, int position) {

            holder.cityName.setText(cities.get(position).getCity());
            holder.temperature.setText(cities.get(position).getTemperature().toString() + "°C");

            switch (cities.get(position).getIcon()){
                case "d01":
                    holder.icon.setImageResource(R.drawable.d01);
                    break;
                case "d02":
                    holder.icon.setImageResource((R.drawable.d02));
                    break;
                case "d03":
                    holder.icon.setImageResource(R.drawable.d03);
                    break;
                case "d04":
                    holder.icon.setImageResource(R.drawable.d04);
                    break;
            }
            //This is how I would set the data from weatherList
            /*
            if(weatherList != null){
                holder.cityName.setText(weatherInfo.get(position).getName());
                holder.temperature.setText(weatherInfo.get(position).getMain().getTemp().toString());
            }*/

        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView temperature;
        ImageView icon;

        View.OnClickListener cardOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                Intent intent = new Intent(v.getContext(), DetailedInformationActivity.class);
                intent.putExtra(EXTRA_MESSAGE, position);
                startActivity(intent);
            }
        };

        WeatherViewHolder(View itemView){
            super(itemView);
            cityName = (TextView) itemView.findViewById(R.id.city);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            itemView.setOnClickListener(cardOnClickListener);
        }

    }
}
