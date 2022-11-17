package com.masum.simpleweather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
public class Weather extends AsyncTask<String, Void, String>{
    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myConnection = null;

        try{
        link = new URL(urls[0]);
        myConnection = (HttpURLConnection) link.openConnection();
        InputStream in = myConnection.getInputStream();
        InputStreamReader myStreamReader = new InputStreamReader(in);
        int data = myStreamReader.read();
        while(data!=-1){
            char current = (char)data;
            result+= current;
            data = myStreamReader.read();
        }
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);

        try{
            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            String temperature = main.getString("temp");
            String feels = main.getString("feels_like");
            String tempMin = main.getString("temp_min");
            String tempMax = main.getString("temp_max");
            String humi = main.getString("humidity");
            String placeName = myObject.getString("name");

            MainActivity.place.setText(placeName);
            MainActivity.temp.setText(temperature);
            MainActivity.feelsLikeBtn.setText(feels);
            MainActivity.minTempBtn.setText(tempMin);
            MainActivity.maxTempBtn.setText(tempMax);
            MainActivity.humidityBtn.setText(humi);

        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

}
