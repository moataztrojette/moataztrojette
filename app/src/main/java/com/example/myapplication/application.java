package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class application extends AppCompatActivity {
    Button goacce;
    Button goGarage;
    Button goSalledeBain;
    Button goCusine;
    Button goSalle;
    Button gochambre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        goacce=findViewById(R.id.goAcceuil24);

        goacce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(application.this,   Acceuil.class);
                startActivity(intent); }


        });



        goGarage=findViewById(R.id.startgarage);
        goGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(application.this,Garage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);


            }
        });

        goSalledeBain=findViewById(R.id.startsalledebain);
        goSalledeBain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(application.this,salleDeBains.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);

            }
        });

        gochambre=findViewById(R.id.startchambre);
        gochambre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(application.this, chambre.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);

            }
        });
        goCusine=findViewById(R.id.startcuisine);
        goCusine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (application.this,cuisine.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);

            }
        });

        goSalle=findViewById(R.id.startsalle);
        goSalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (application.this, Salle.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);

            }
        });




    }
}