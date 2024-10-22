package com.azeem.dynamicuiapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        //call createusernameinput function
    }
    //create createusernameinput function

    private void createUsernameInput(){
        mainLayout.removeAllViews();
        usernameField = new EditText(this);
        passwordField = new EditText(this);


    }

        //define feilds and hint add continue and back button
        //add all fields to layout

    //create createusernamecontinue function
        //
        // make username vriable to store
        //field color to red


    // create createpasswordinput for feilds and buttons


    //create onpasswordcontinue function
        //if field is empty turn red

    //create showuserinfo
        //variable for datetime and infotext
}