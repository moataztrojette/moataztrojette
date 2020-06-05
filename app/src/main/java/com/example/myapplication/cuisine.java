package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cuisine extends AppCompatActivity implements View.OnClickListener {
    Button go23 , cuisineLedOn ,cuisineLedOff ,cuisineGasStoveOn , cuisineGasStoveOff , cuisineVentilateurOn , cuisineVentilateurOff;
    DatabaseReference myRefled , myRefGas ,myRefVentilateur ;
    FirebaseDatabase database ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        cuisineLedOn = findViewById(R.id.cuisineLedOn) ;
        cuisineLedOff = findViewById(R.id.cuisineLedOff) ;
        cuisineGasStoveOn = findViewById(R.id.cuisineGasStoveOn) ;
        cuisineGasStoveOff = findViewById(R.id.cuisineGasStoveOff) ;
        cuisineVentilateurOn  = findViewById(R.id.cuisineVentilateurOn) ;
        cuisineVentilateurOff  = findViewById(R.id.cuisineVentilateurOff) ;

        cuisineLedOn.setOnClickListener(this);
        cuisineLedOff.setOnClickListener(this);
        cuisineGasStoveOn.setOnClickListener(this);
        cuisineGasStoveOff.setOnClickListener(this);
        cuisineVentilateurOn.setOnClickListener(this);
        cuisineVentilateurOff.setOnClickListener(this);

        database =  FirebaseDatabase.getInstance();
        myRefled = database.getReference("cuisine/led");
        myRefGas = database.getReference("cuisine/Gas");
        myRefVentilateur = database.getReference("cuisine/ventilateur");


        go23=findViewById(R.id.acceuil23);
        go23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cuisine.this,application.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.cuisineLedOn :
                myRefled.setValue("on");
                break ;
            case R.id.cuisineLedOff :
                myRefled.setValue("off");
                break ;
            case R.id.cuisineGasStoveOn :
                myRefGas.setValue("on");
                break ;
            case R.id.cuisineGasStoveOff :
                myRefGas.setValue("off");
                break ;
            case R.id.cuisineVentilateurOn :
                myRefVentilateur.setValue("on");
                break ;
            case R.id.cuisineVentilateurOff :
                myRefVentilateur.setValue("off");
                break ;
        }

    }
}
