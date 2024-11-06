package com.azeem.dynamicuiapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
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

    // Define variables for the username field, password field, and buttons.
    private TextView usernameField;
    private TextView passwordField;
    private Button continueButton;
    private Button backButton;
    private LinearLayout mainLayout; // Define the main layout for dynamic UI.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call the parent constructor for setup.

        mainLayout = new LinearLayout(this); // Create a new LinearLayout.

        mainLayout.setOrientation(LinearLayout.VERTICAL); // Set layout orientation to vertical.

        setContentView(mainLayout); // Set mainLayout as the activity content view.
        createUsernameInput(); // Call function to create username input view.

    }

    @SuppressLint("ClickableViewAccessibility")
    private void createUsernameInput() {
        mainLayout.removeAllViews(); // Clear any existing views in the layout.

        usernameField = new EditText(this); // Initialize EditText for the username.
        usernameField.setHint("Enter Username"); // Set hint for the username field.
        usernameField.setOnTouchListener((view, motionEvent) -> {
            view.setBackgroundColor(Color.TRANSPARENT);
            return true;
        });

        continueButton = new Button(this); // Create a button for continue action.
        continueButton.setText("Continue"); // Set button text to "Continue".
        continueButton.setOnClickListener(view -> onUsernameContinue()); // Set click listener to call onUsernameContinue.

        mainLayout.addView(usernameField); // Add username field to layout.
        mainLayout.addView(continueButton); // Add continue button to layout.
    }


    private void onUsernameContinue(){
        String username = usernameField.getText().toString(); // Get the text entered in username field.

        // Check if the username field is empty.
        if (username.isEmpty()){
            usernameField.setBackgroundColor(0xFFFF0000); // Set background color to red to indicate an error.
            Toast.makeText(this,"Username cannot be empty",Toast.LENGTH_SHORT).show(); // Show error message.
        } else {
            createPasswordInput(username); // Call function to create password input if username is valid.
        }

    }


    @SuppressLint("ClickableViewAccessibility")
    private void createPasswordInput(String username){
        mainLayout.removeAllViews(); // Clear existing views.

        passwordField = new EditText(this); // Initialize EditText for password.
        passwordField.setHint("Enter Password"); // Set hint text for password field.


        passwordField.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_PASSWORD); // Set input type to password (masked).

        continueButton = new Button(this); // Create continue button.
        continueButton.setText("Continue"); // Set text to "Continue".
        continueButton.setOnClickListener(view -> onPasswordContinue(username)); // Set click listener to call onPasswordContinue with username.

        backButton = new Button(this); // Create back button.
        backButton.setText("Back"); // Set text to "Back".
        backButton.setOnClickListener(view -> onBack()); // Set click listener to call onBack.

        mainLayout.addView(passwordField); // Add password field to layout.
        mainLayout.addView(continueButton); // Add continue button to layout.
        mainLayout.addView(backButton); // Add back button to layout.
    }

    private void onPasswordContinue(String username){
        String password = passwordField.getText().toString(); // Get text from password field.

        // Check if password field is empty.
        if (password.isEmpty()){
            passwordField.setBackgroundColor(0xFFFF0000); // Set background color to red for error indication.
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show(); // Show error message.
        } else{
            showUserInfo(username); // Call function to show user information if password is valid.
        }
    }

    private void showUserInfo(String username){
        mainLayout.removeAllViews(); // Clear existing views.

        // Format current date and time as a string.
        String currentDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",
                Locale.getDefault()).format(new Date());

        // Create a text to display username and current date/time.
        String infoText = "Username: " + username + "\nCurrent DateTime: " + currentDate;

        TextView userInfo = new TextView(this); // Create TextView for displaying user information.
        userInfo.setText(infoText); // Set text with username and date/time.

        backButton = new Button(this); // Create back button.
        backButton.setText("Back"); // Set text to "Back".
        backButton.setOnClickListener(view -> onBack()); // Set click listener to call onBack.

        mainLayout.addView(userInfo); // Add user information TextView to layout.
        mainLayout.addView(backButton); // Add back button to layout.
    }

    private void onBack(){
        createUsernameInput(); // Return to the initial username input view.
    }
}
