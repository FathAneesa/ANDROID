package com.example.pro6;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioButton rbMale, rbFemale;
    CheckBox cbTerms;
    Switch switch1;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI elements
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbTerms = findViewById(R.id.cbTerms);
        switch1 = findViewById(R.id.switch1);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Button click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        // Name Validation
        String name = etName.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return;
        }

        // Email Validation
        String email = etEmail.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            return;
        }

        // Password Validation
        String password = etPassword.getText().toString();
        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return;
        }

        // Gender Validation
        if (!rbMale.isChecked() && !rbFemale.isChecked()) {
            Toast.makeText(this, "Select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        // Terms & Conditions Validation
        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Switch Validation
        if (!switch1.isChecked()) {
            Toast.makeText(this, "Please enable the switch (New Member)", Toast.LENGTH_SHORT).show();
            return;
        }

        // All validations passed
        Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_LONG).show();
    }
}
