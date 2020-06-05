package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Garage extends AppCompatActivity  {
    // Write a message to the database
    FirebaseDatabase database ;
    DatabaseReference myRefEtage , myRefGarage ;

    Button go21 , on , off , up , down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        go21=findViewById(R.id.acceuil21);
        on = findViewById(R.id.garageOn) ;
        off = findViewById(R.id.garageOff) ;
        up = findViewById(R.id.garageUp) ;
        down = findViewById(R.id.garageDown) ;
        database =  FirebaseDatabase.getInstance();
        myRefGarage = database.getReference("garage/port");
        myRefEtage = database.getReference("garage/etage");
        go21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Garage.this,application.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);

            }
        });

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefGarage.setValue("on");
            }
        });

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefGarage.setValue("off");
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefEtage.setValue("up");
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefEtage.setValue("down");
            }
        });

    }


}
