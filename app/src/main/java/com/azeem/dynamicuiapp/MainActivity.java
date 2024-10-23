package com.azeem.dynamicuiapp;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //declare all feilds and buttons and layout
    private TextView usernameField;
    private TextView passwordField;
    private Button continueButton;
    private Button backButton;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize layout to vertical
        mainLayout = new LinearLayout(this); // 'this' refers to the context (MainActivity)

        mainLayout.setOrientation(LinearLayout.VERTICAL);

        setContentView(mainLayout); // Set the main layout as the content view
        //call createusernameinput function
        createUsernameInput();

    }
    //create createusernameinput function
        //define feilds and hint add continue and back button

        //add all fields to layout

    private void createUsernameInput(){
        mainLayout.removeAllViews(); // Clear any existing views in the layout
        usernameField = new EditText(this);
        usernameField.setHint("Enter Username");
        passwordField = new EditText(this);
        passwordField.setHint("ENter Password");
        continueButton = new Button(this);
        continueButton.setText("Continue");
        continueButton.setOnClickListener(view -> onUsernameContinue());
        backButton = new Button(this);
        backButton.setText("Back");
        backButton.setOnClickListener(view -> onBack());

        // Add the username field and buttons to the main layout
        mainLayout.addView(usernameField);
        mainLayout.addView(continueButton);
        mainLayout.addView(backButton);
    }



    //create createusernamecontinue function
        //
        // make username vriable to store
        //field color to red
    private void onUsernameContinue(){

        String username = usernameField.getText().toString();
        if (username.isEmpty()){
            usernameField.setBackgroundColor(0xFFFF0000);
            Toast.makeText(this,"Usename can not be empty",Toast.LENGTH_SHORT).show();
        } else {
            createPasswordInput(username);
        }

    }

    // create createpasswordinput for feilds and buttons

    private void createPasswordInput(String username){
        mainLayout.removeAllViews(); // Clear any existing views in the layout
        // Create an EditText for the password input
        passwordField = new EditText(this);
        passwordField.setHint("Enter Password"); // Set hint text
        passwordField.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD); // Set to password input type

        continueButton = new Button(this);
        continueButton.setText("Continue");
        continueButton.setOnClickListener(view -> onPasswordContinue(username));

        backButton = new Button(this);
        backButton.setText("Back");
        backButton.setOnClickListener(view -> onBack());

        // Add the password field and buttons to the main layout
        mainLayout.addView(passwordField);
        mainLayout.addView(continueButton);
        mainLayout.addView(backButton);

    }
    //create onpasswordcontinue function
        //if field is empty turn red
    private void onPasswordContinue(String username){
        String password = passwordField.getText().toString();
        if (password.isEmpty()){
            passwordField.setBackgroundColor(0xFFFF0000);
            Toast.makeText(this, "Password can not be empty", Toast.LENGTH_SHORT).show();

        } else{
            //showUserInfo(username);
        }

    }


    //create showuserinfo
        //variable for datetime and infotext

    private void onBack(){
        createUsernameInput();
    }
}
