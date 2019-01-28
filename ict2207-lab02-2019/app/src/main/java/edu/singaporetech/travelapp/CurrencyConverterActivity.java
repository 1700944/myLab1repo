package edu.singaporetech.travelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.parseFloat;

/**
 * Activity that displays UI to convert currency
 */
public class CurrencyConverterActivity extends AppCompatActivity {

    private static final String TAG = "CurrencyConverter";
    // TODO variables to hold the UI elements
    EditText editTextCurrency;
    EditText editTextRate;
    EditText editTextSingDollar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        // TODO findviewbyid for the UI elements
        editTextCurrency  = findViewById(R.id.editTextCurrency);
        editTextRate = findViewById(R.id.editTextRate);
        editTextSingDollar =findViewById(R.id.editTextSingDollar);
        final TextView Converted = findViewById(R.id.currencyview);
        Button currencyBtn = findViewById(R.id.convCurrBtn);

        // TODO set onClickListeners to all the buttons here
        // or declare the onclick method within the layout XML?
        currencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float value = parseFloat(editTextSingDollar.getText().toString());
                float exchangeRate =  parseFloat(editTextRate.getText().toString());
                float r = calculateRate(value,exchangeRate);
                String output = Float.toString(value) +" SGD is " + Float.toString(r) + editTextCurrency.getText().toString();
                Converted.setText(output);
            }
        });
    }

    /**
     * Formula to calculate the destination currency
     * @param value
     * @param exchangeRate
     * @return
     */
    public float calculateRate(float value, float exchangeRate) {
        // TODO What's the formula you need?
        return (value * exchangeRate);
    }
}


