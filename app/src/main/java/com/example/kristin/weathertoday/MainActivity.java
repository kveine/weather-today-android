package com.example.kristin.weathertoday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Data.WeatherProviderHC;
import Interface.WeatherAPI;
import Model.Weather;
import Model.WeatherHC;
import Model.WeatherPOJO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.kristin.cardviewtest.position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.city_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new WeatherListAdapter(new WeatherProviderHC().readWeather()));

        //Code to collect data using Retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/").build();
        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        /*weatherAPI.getWeatherInformation("Oslo", "5a3d6fa759a2e9ecd6ade28247c684d3", new Callback<WeatherPOJO>() {
            @Override
            public void onResponse(Call<WeatherPOJO> call, Response<WeatherPOJO> response) {
                //set values for TextView
            }

            @Override
            public void onFailure(Call<WeatherPOJO> call, Throwable t) {
                //print error message
            }
        });*/
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
            holder.temperature.setText(cities.get(position).getTemperature());
        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{
        TextView cityName;
        TextView temperature;

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
            cityName = (TextView) itemView.findViewById(R.id.quiz_question);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            itemView.setOnClickListener(cardOnClickListener);
        }

    }
}
