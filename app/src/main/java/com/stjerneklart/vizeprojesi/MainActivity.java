package com.stjerneklart.vizeprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button convertorbtn = (Button) findViewById(R.id.convertor);
        convertorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Convertor.class);
                startActivity(intent);
            }
        });

        Button randombtn = (Button) findViewById(R.id.random);
        randombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Convertor.class);
                startActivity(intent);
            }
        });

        Button smsbtn = (Button) findViewById(R.id.sms);
        smsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Convertor.class);
                startActivity(intent);
            }
        });


    }
}