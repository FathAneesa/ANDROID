package com.example.pro2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText n=findViewById(R.id.editTextText);
                EditText p=findViewById(R.id.editTextText2);
                String name=n.getText().toString();
                String pass=p.getText().toString();
                if(name.equals("aneesa") & pass.equals("aneesa@123"))
                {
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
