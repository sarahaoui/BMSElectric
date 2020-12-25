package com.example.bmselectric;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Client extends AppCompatActivity {
    Button getLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__client);
        getLocation = (Button) findViewById(R.id.getLocation);
        getLocation.setBackgroundColor(Color.TRANSPARENT);
    }

    public void getLocation(View view) {


    }
}