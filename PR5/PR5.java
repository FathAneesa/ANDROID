package com.example.pro5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText numb1, numb2;
    private TextView viewResult;
    private Button add, sub, mul, div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numb1 = findViewById(R.id.editTextText);
        numb2 = findViewById(R.id.editTextText2);
        viewResult = findViewById(R.id.textView);
        add = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mul = findViewById(R.id.button3);
        div = findViewById(R.id.button4);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('+');
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('-');
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('*');
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate('/');
            }
        });
    }


    private void calculate(char c) {
        String input1 = numb1.getText().toString();
        String input2 = numb2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show();
            return;

        }
        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (c) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        viewResult.setText("View Result: " + result);
    }
}

