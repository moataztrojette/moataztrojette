package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//bibliotheque
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class chambre extends AppCompatActivity {

    //decalartion//
    Button goa20;
    FirebaseDatabase database ;
    DatabaseReference myRefOn, myRefOff ;
    Button ChambreOn , ChambreOff , ChambreOpen , ChambreClose , down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chambre);

        //id
        ChambreOn =findViewById(R.id.ChambreOn);
        ChambreOff = findViewById(R.id.ChambreOff) ;
        ChambreOpen = findViewById(R.id.ChambreOpen) ;
        ChambreClose = findViewById(R.id.ChambreClose) ;


        database =  FirebaseDatabase.getInstance();

        //connection avec firebase
        myRefOn = database.getReference("Chambre/led");
        myRefOff = database.getReference("Chambre/window");

        //lien vers page application
        goa20=findViewById(R.id.acceuil20);
        goa20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (chambre.this,application.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);

            }
        });

        ChambreOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefOn.setValue("LEDon");
            }
        });

        ChambreOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefOn.setValue("LEDoff");
            }
        });

        ChambreOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefOff.setValue("windowOpen");
            }
        });

        ChambreClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRefOff.setValue("windowClose");
            }
        });


    }
}

