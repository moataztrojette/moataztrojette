package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SmartHouse extends AppCompatActivity {
    Button goAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_house);
        goAcc=findViewById(R.id.acceuil4);

        goAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SmartHouse.this,   Acceuil.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);




            }
        });
    }
}