package edu.singaporetech.travelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Lab 02: Travel App
 * Main Screen
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO findviewbyid for the UI elements
        Button emailbtn = findViewById(R.id.EmailBtn);
        Button currencybtn = findViewById(R.id.CurrencyBtn);
        Button tempbtn = findViewById(R.id.tmpbtn);
        Log.d("MainActivity", "Hello, green robot");
        // TODO set onClickListeners to all the buttons here
        // or declare the onclick method within the layout XML?
    }
    public void temperatureOnClick(View view){
        //setContentView(R.layout.activity_temp_converter);
        Intent convTempIntent = new Intent(view.getContext(),TempConverterActivity.class);
        startActivity(convTempIntent);
    }
    public void currencyOnClick (View view){
        //setContentView(R.layout.activity_currency_converter);
        Intent convCurrIntent = new Intent(view.getContext(),CurrencyConverterActivity.class);
        startActivity(convCurrIntent);
    }
    public void  emailOnClick (View view){
        //setContentView(R.layout.activity_email);
        Intent emailIntent = new Intent(view.getContext(),EmailActivity.class);
        startActivity(emailIntent);
    }

}
