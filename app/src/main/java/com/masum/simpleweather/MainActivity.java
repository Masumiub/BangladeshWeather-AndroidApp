package com.masum.simpleweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.awt.font.TextAttribute;
import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {

    public static Button feelsLikeBtn;
    public static Button minTempBtn;
    public static Button maxTempBtn;
    public static Button humidityBtn;

    static TextView place;
    static TextView temp;
    static TextView description;

    static TextView inputplace;
    static TextView inputtemp;

    static TextView barisalplace;
    static TextView barisaltemp;

    static TextView chittagongplace;
    static TextView chittagongtemp;

    static TextView sylhetplace;
    static TextView sylhettemp;

    private EditText cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //for hiding the top action bar.
        setContentView(R.layout.activity_main);

        place = (TextView) findViewById(R.id.placeInput);
        temp = (TextView) findViewById(R.id.tempInput);
        //description = (TextView) findViewById(R.id.des);
        feelsLikeBtn = (Button) findViewById(R.id.feelsLike);
        minTempBtn = (Button) findViewById(R.id.minTemp);
        maxTempBtn = (Button)findViewById(R.id.maxTemp);
        humidityBtn = (Button)findViewById(R.id.humidity);

        cityName = (EditText) findViewById(R.id.enterCity);

        inputplace = (TextView) findViewById(R.id.inputCityname);
        inputtemp = (TextView)findViewById(R.id.inputTemp);

        barisalplace = (TextView) findViewById(R.id.barisalname);
        barisaltemp = (TextView) findViewById(R.id.barisalTemp);

        chittagongplace = (TextView) findViewById(R.id.Chittagongname);
        chittagongtemp = (TextView) findViewById(R.id.ChittagongTemp);

        sylhetplace = (TextView) findViewById(R.id.sylhetname);
        sylhettemp = (TextView) findViewById(R.id.sylhetTemp);

        Weather getData = new Weather();
        getData.execute("https://api.openweathermap.org/data/2.5/weather?q=Dhaka&appid=e94ca0be26609f28422f7a878294760a&units=metric");

        BarishalWeather getData2 = new BarishalWeather();
        getData2.execute("https://api.openweathermap.org/data/2.5/weather?q=Barisal&appid=e94ca0be26609f28422f7a878294760a&units=metric");

        ChittagongWeather getData3 = new ChittagongWeather();
        getData3.execute("https://api.openweathermap.org/data/2.5/weather?q=Chittagong&appid=e94ca0be26609f28422f7a878294760a&units=metric");

        SylhetWeather getData4 = new SylhetWeather();
        getData4.execute("https://api.openweathermap.org/data/2.5/weather?q=Sylhet&appid=e94ca0be26609f28422f7a878294760a&units=metric");
    }

    public void Show(View view) {
        String InputcityName = cityName.getText().toString();

        InputWeather getData = new InputWeather();
        getData.execute("https://api.openweathermap.org/data/2.5/weather?q=" + InputcityName + "&appid=e94ca0be26609f28422f7a878294760a&units=metric");

        cityName.setText("");
    }
}