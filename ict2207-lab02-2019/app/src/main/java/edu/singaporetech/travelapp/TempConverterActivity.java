package edu.singaporetech.travelapp;

import android.content.Intent;
import android.hardware.SensorAdditionalInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Float.parseFloat;

/**
 * Activity that displays UI to convert temperature
 */
public class TempConverterActivity extends AppCompatActivity {

    private static final String TAG = "TempConverter";
    // TODO variables to hold the UI elements
    //EditText temperatureTxt;
    //TextView convertedTxt;
    //RadioButton radioButton_fah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        // TODO findviewbyid for the UI elements
        Button convert = findViewById(R.id.convert_btn);
        Button clear = findViewById(R.id.clear_btn);
;

        final RadioButton rb = (RadioButton) findViewById(R.id.celsius_rb);
        final TextView convertedTxt = (TextView) findViewById(R.id.editText);
        final EditText temperatureTxt = (EditText) findViewById(R.id.editTextTemp);
        // TODO set onClickListeners to all the buttons here
        // or declare the onclick method within the layout XML?
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float temp = Float.parseFloat(temperatureTxt.getText().toString());

                if (convertedTxt.toString() != "") {
                    if (rb.isChecked()) {
                        float conTemp = convertFahrenheitToCelsius(temp);
                        convertedTxt.setText(temp + " Celsius is " + conTemp + " Fahrenheit");
                    } else {
                        float conTemp = convertCelsiusToFahrenheit(temp);
                        convertedTxt.setText(temp + " Fahrenheit is " + conTemp + " Celsius");
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureTxt.setText("");
                convertedTxt.setText("");

            }
        });

    }

    // TODO - Implement the temperature conversion logic and other behavior here
    // What methods do you need?
    public void convertTemperature() {
        //Get float from EditText
        EditText edt = findViewById(R.id.editTextTemp);
        float number = Float.valueOf(edt.getText().toString());
    }


    /**
     * Converts fahrenheit to celsius
     * @param fahrenheit temperature in f
     * @return
     */
    public float convertFahrenheitToCelsius(float fahrenheit) {
        // TODO What's the formula you need?
        return  ( 5 *(fahrenheit - 32)) / 9;

    }

    /**
     * Converts celsius to fahrenheit
     * @param celsius temperature in c
     * @return
     */
    public float convertCelsiusToFahrenheit(float celsius) {
        // TODO What's the formula you need?
        return   celsius * (9 / 5) + 32;

    }
}
