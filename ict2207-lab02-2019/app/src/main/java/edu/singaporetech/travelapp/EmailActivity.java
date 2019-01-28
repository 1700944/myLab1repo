package edu.singaporetech.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity that emails your friend with a message
 */
public class EmailActivity extends AppCompatActivity {

    private static final String TAG = "EmailActivity";
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        // TODO findviewbyid for the UI elements
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextCity = findViewById(R.id.editTextCity);

        Button sendbtn = findViewById(R.id.sendemailbtn);
        final Button previewbtn = findViewById(R.id.previewbtn);
        // TODO set onClickListeners to all the buttons here
        // or declare the onclick method within the layout XML?
        //Send Email
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        //Preview Email
        previewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String city = editTextCity.getText().toString();
                String mesg = createEmailMessage(name,city);
                TextView prevMessage = findViewById(R.id.prevMessage);
                prevMessage.setText(mesg);
            }
        });
        Log.d(TAG, "onCreate");
        Log.d(TAG, createEmailMessage("Jeannie", "Los Angeles"));


    }
    /**
     * Call an intent to start the email app
     */
    public void sendEmail() { // do you need to change the parameters?
        // Subject will not be changed as it is a travel app
        String subject = "Going on vacation";

        // Email address can add more than just one with separator of ,
        String recipientList =editTextEmail.getText().toString();
        String[] recipients = recipientList.split(",");

        // Get message from function
        String name = editTextName.getText().toString();
        String city = editTextCity.getText().toString();
        String mesg = createEmailMessage(name,city);

        // TODO: Use an intent to launch an email app.
        Intent intent = new Intent(Intent.ACTION_SEND);

        // TODO call createEmailMessage to generate the email message
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,mesg);

        // TODO call startActivity(intent);
        intent.setType("text/plain");
        startActivity(intent);
        /*if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }*/

    }

    /**
     * Creates the string to send in the email message
     * @param name
     * @param city
     * @return the email message
     */
    private String createEmailMessage(String name, String city) {
        String emailMessage = getString(R.string.hey) + " " + name + " "
                + getString(R.string.im_going_to) + " " + city + "!";
        return emailMessage;
    }

}
