package com.example.kessr.saphackathon;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeatherInformation extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;

    private double lat;
    private double lon;

    ImageView weatherDay;
    ImageView weatherNight;

    ImageView sunnyImageView;
    ImageView rainImageView;
    ImageView cloudyImageView;

    JSONObject currWeather = null;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);
            }
        }
    }

    public void getWeather(double lat, double lon) {
        String URL = "https://api.darksky.net/forecast/f0fd7aef706203953d2ec519be557343/"+Double.toString(lat)+","+Double.toString(lon);
        //String URL = "https://api.darksky.net/forecast/f0fd7aef706203953d2ec519be557343/20,-122.4233";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response", response.toString());
                        try{
                            currWeather = response.getJSONObject("currently");
                            renderWeatherInformation();
                        }catch (JSONException e){
                            Log.i("Error", "Cannot fetch data from JSON Object");
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("Error", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);
    }

    private void renderWeatherInformation() throws JSONException{
        TextView temperatureText = (TextView)findViewById(R.id.temperatureText);
        float degrees = toCelsius(Float.parseFloat(currWeather.get("temperature").toString()));
        temperatureText.setText(Integer.toString(Math.round(degrees)));

        String icon = currWeather.get("icon").toString();
        Log.i("Information", icon);
        if(icon.equals("clear-day") || icon.equals("wind")){
            clearRender();
            sunnyImageView.setVisibility(View.VISIBLE);
        }else if(icon.equals("rain") || icon.equals("snow") || icon.equals("sleet")){
            clearRender();
            rainImageView.setVisibility(View.VISIBLE);
        }else if(icon.equals("fog") || icon.equals("cloudy")){
            clearRender();
            cloudyImageView.setVisibility(View.VISIBLE);
        }else if(icon.equals("partly-cloudy-day")){
            clearRender();
            cloudyImageView.setVisibility(View.VISIBLE);
            sunnyImageView.setVisibility(View.VISIBLE);
        }else{
            Log.i("Info", "Hi");
            clearRender();
            cloudyImageView.setVisibility(View.VISIBLE);
        }
        int time = getCurrentTime();

        if(time>=17 || time<=7){
            weatherNight.setVisibility(View.VISIBLE);
            weatherDay.setVisibility(View.INVISIBLE);
        }else{
            weatherDay.setVisibility(View.VISIBLE);
            weatherNight.setVisibility(View.INVISIBLE);
        }
    }

    private float toCelsius(float degreesf){
        return (degreesf-32)*5/9;
    }

    private int getCurrentTime(){
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(calendar.HOUR_OF_DAY);
    }

    private void clearRender(){
        weatherNight.setVisibility(View.INVISIBLE);
        rainImageView.setVisibility(View.INVISIBLE);
        cloudyImageView.setVisibility(View.INVISIBLE);
        sunnyImageView.setVisibility(View.INVISIBLE);
        weatherDay.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        weatherDay = (ImageView)findViewById(R.id.weatherDay);
        weatherNight = (ImageView)findViewById(R.id.weatherNight);

        sunnyImageView = (ImageView)findViewById(R.id.sunnyImageView);
        rainImageView = (ImageView)findViewById(R.id.rainImageView);
        cloudyImageView = (ImageView)findViewById(R.id.cloudyImageView);

        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("Location", location.toString());
                lat = location.getLatitude();
                lon = location.getLongitude();
                try {
                    getWeather(lat, lon);
                }catch (Error e){
                    Log.i("Error: ", e.getMessage());
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, locationListener);
        }

        clearRender();
    }


}
